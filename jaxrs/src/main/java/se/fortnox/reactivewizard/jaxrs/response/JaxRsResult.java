package se.fortnox.reactivewizard.jaxrs.response;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static javax.ws.rs.core.HttpHeaders.CONTENT_LENGTH;
import static rx.Observable.empty;
import static rx.Observable.just;

/**
 * Represents a result of a call to a JaxRs resource. Contains the output but also some meta data about the call.
 * This class is passed to the output processors.
 */
public class JaxRsResult<T> {
    protected static final byte[] EMPTY_RESPONSE = new byte[0];

    protected final Func1<T, byte[]>    serializer;
    protected final Map<String, Object> headers = new HashMap<>();
    protected       Observable<T>       output;
    protected       HttpResponseStatus  responseStatus;

    public JaxRsResult(Observable<T> output, HttpResponseStatus responseStatus, Func1<T, byte[]> serializer, Map<String, Object> headers) {
        this.output = output;
        this.responseStatus = responseStatus;
        this.serializer = serializer;
        this.headers.putAll(headers);
    }

    public HttpResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public JaxRsResult<T> addHeader(String key, Object value) {
        headers.put(key, value);
        return this;
    }

    public JaxRsResult<T> doOnOutput(Action1<T> action) {
        output = output.doOnNext(action);
        return this;
    }

    public JaxRsResult<T> map(Func1<Observable<T>, Observable<T>> mapFunction) {
        output = mapFunction.call(output);
        return this;
    }

    public Observable<Void> write(HttpServerResponse<ByteBuf> response) {
        AtomicBoolean headersWritten = new AtomicBoolean();
        return output
            .map(serializer)
            .defaultIfEmpty(EMPTY_RESPONSE)
            .flatMap(bytes -> {
                int contentLength = getContentLength(bytes);

                if (headersWritten.compareAndSet(false, true)) {
                    response.setStatus(responseStatus);
                    headers.forEach(response::addHeader);
                    response.addHeader(CONTENT_LENGTH, contentLength);
                }

                if (contentLength > 0) {
                    return response.writeBytes(just(bytes));
                }

                return empty();
            });
    }

    private int getContentLength(byte[] bytes) {
        return bytes != null ? bytes.length : 0;
    }
}
