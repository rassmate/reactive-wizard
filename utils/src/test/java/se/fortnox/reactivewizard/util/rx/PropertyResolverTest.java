package se.fortnox.reactivewizard.util.rx;

import org.junit.Test;
import se.fortnox.reactivewizard.util.PropertyResolver;

import static org.fest.assertions.Assertions.assertThat;

public class PropertyResolverTest {
    @Test
    public void shouldGetAndSetPropertiesMutable() throws Exception {
        PropertyResolver propertyResolver = PropertyResolver.from(Mutable.class, new String[]{"anInt"}).orElse(null);
        assertThat(propertyResolver).isNotNull();

        Mutable mutable = new Mutable();
        mutable.setAnInt(5);
        assertThat(propertyResolver.getter().apply(mutable)).isEqualTo(5);
        propertyResolver.setter().accept(mutable, 10);
        assertThat(propertyResolver.getter().apply(mutable)).isEqualTo(10);
    }

    @Test
    public void shouldGetAndSetPropertiesImmutable() throws Exception {
        PropertyResolver propertyResolver = PropertyResolver.from(Immutable.class, new String[]{"anInt"}).orElse(null);
        assertThat(propertyResolver).isNotNull();

        Immutable immutable = new Immutable(5);
        assertThat(propertyResolver.getter().apply(immutable)).isEqualTo(5);
        propertyResolver.setter().accept(immutable, 10);
        assertThat(propertyResolver.getter().apply(immutable)).isEqualTo(10);
    }

    public static class Mutable {
        private int anInt;

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }
    }

    public static class Immutable {
        private final int anInt;

        public Immutable(int anInt) {
            this.anInt = anInt;
        }

        public int getAnInt() {
            return anInt;
        }
    }
}
