package se.fortnox.auth;

import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import se.fortnox.CustomerRepository;
import se.fortnox.Customers;
import se.fortnox.reactivewizard.binding.AutoBindModule;
import se.fortnox.reactivewizard.client.PreRequestHook;

public class PreRequstHookModule implements AutoBindModule {
    @Override
    public void configure(Binder binder) {
        Multibinder.newSetBinder(binder, PreRequestHook.class).addBinding().to(AuthenticatingPreRequestHook.class);
        binder.bind(CustomerRepository.class).to(Customers.class).in(Scopes.SINGLETON);
    }
}
