package core.utils.session;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Vitalii_Strieltsov on 11/15/2018
 */
public class Session {

  private static final ThreadLocal<TestSessionMap<Key, Object>> SESSION = new InheritableThreadLocal<>();

  private static TestSessionMap<Key, Object> getSession() {
    if (Objects.isNull(SESSION.get())) {
      SESSION.set(new TestSessionMap<>());
    }
    return SESSION.get();
  }

  public static void putDataInSession(final Key key, final Object value) {
    getSession().put(key, value);
  }

  private static class TestSessionMap<K, V> extends ConcurrentHashMap {

    @Override
    public Object put(final Object key, final Object value) {
      return Objects.isNull(value) ? super.remove(key) : super.put(key, value);
    }

  }

  public static Object get(final Key key) {
    return getSession().get(key);
  }

  public static void clearSession() {
    getSession().clear();
    SESSION.remove();
  }

  public static <T> T get(final Key key, final Class<?> type) {
    Object value = getSession().get(key);
    return Objects.nonNull(value) ? (T) value : null;
  }
}
