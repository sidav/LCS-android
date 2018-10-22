package lcs.android.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import lcs.android.game.Game;

// import org.eclipse.jdt.annotation.NonNullByDefault;
// import org.eclipse.jdt.annotation.Nullable;

/** A wrapper of a Map class, which throws exceptions if duplicates are added, or
 * null values are retrieved.
 * @author addie
 * @param <K> Keys
 * @param <V> Values */
public class NoDupeNoEmptyMap<K, V> implements Map<K, V>, Serializable {
  public NoDupeNoEmptyMap(final Map<K, V> delegate) {
    this.delegate = delegate;
  }

  private final Map<K, V> delegate;

  @Override public void clear() {
    delegate.clear();
  }

  @Override public boolean containsKey(final Object key) {
    return delegate.containsKey(key);
  }

  @Override public boolean containsValue(final Object value) {
    return delegate.containsValue(value);
  }

  @Override public Set<java.util.Map.Entry<K, V>> entrySet() {
    return delegate.entrySet();
  }

  @Override public V get(final Object key) {
    final V rval = delegate.get(key);
    if (rval == null)
      throw new IllegalArgumentException("No object for key:" + key);
    return rval;
  }

  @Override public boolean isEmpty() {
    return delegate.isEmpty();
  }

  @Override public Set<K> keySet() {
    return delegate.keySet();
  }

  @Override public V put(final K key, final V value) {
    final V rval = delegate.put(key, value);
    if (rval != null)
      throw new IllegalArgumentException("Duplicate object for:" + key);
    return rval;
  }

  @Override public void putAll(final Map<? extends K, ? extends V> map) {
    if (map == null)
      return;
    for (final Entry<? extends K, ? extends V> entry : map.entrySet()) {
      put(entry.getKey(), entry.getValue());
    }
  }

  @Override public V remove(final Object key) {
    final V rval = delegate.remove(key);
    if (rval == null)
      throw new IllegalArgumentException("Can't remove:" + key);
    return rval;
  }

  @Override public int size() {
    return delegate.size();
  }

  @Override public Collection<V> values() {
    return delegate.values();
  }

  private static final long serialVersionUID = Game.VERSION;
}
