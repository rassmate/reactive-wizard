package se.fortnox.reactivewizard.validation;

import javax.inject.Provider;
import javax.validation.Valid;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Validates arguments before proceeding with method calls.
 *
 * Exposes the underlying target for reflection purpose using Provider interface.
 *
 */
class ValidatingProxy implements InvocationHandler, Provider<Object> {

    private final Object target;
    private final ValidatorUtil validatorUtil;

    private ValidatingProxy(Object target, ValidatorUtil validatorUtil) {
        this.target = target;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null) {
            validatorUtil.validateParameters(target, method, args);
        }
        try {
            return method.invoke(target, args);
        } catch (ValidationFailedException e) {
            throw e;
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof RuntimeException) {
                throw (RuntimeException) e.getTargetException();
            }
            throw e;
        }
    }

    /**
     * Wrapped implementation
     * @return the wrapped instance
     */
    @Override
    public Object get() {
        return target;
    }

    /**
     * Creates a proxy for the given service, whihc validates arguments before
     * calling the service.
     *
     * @param serviceInterface is the interface to use for the proxy
     * @param wrappedService is the implementation that will be called
     * @return a proxy validating all calls to the implementation
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<T> serviceInterface, T wrappedService, ValidatorUtil validatorUtil) {
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(),
                new Class[] { serviceInterface },
                new ValidatingProxy(wrappedService, validatorUtil));
    }

}
