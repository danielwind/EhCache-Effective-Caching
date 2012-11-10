package net.danielwind.effcaching.cache;

/**
 * @author Daniel Wind (daniel.wind.m@gmail.com)
 * @copyright (c) 2012 Daniel Wind
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software and Data Processing
 * Algorithms.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 
 * @author danielwind
 *
 * @param <K> Represents the KEY Object
 * @param <V> Represents the VALUE Object
 */
public class EhCacheWrapper<K, V> {
	
	private final String cacheName;
	private final CacheManager cacheManager;
	
	public EhCacheWrapper(String cacheName, CacheManager cacheManager) {
		
		this.cacheName = cacheName;
		this.cacheManager = cacheManager;
	}
	
	public void put(K key, V value){
		getCacheEngine().put(new Element(key, value));
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		
		Element element = getCacheEngine().get(key);
		
		if(element != null){
			return (V) element.getValue();
		}
		
		return (V) element;
	}
	
	private Ehcache getCacheEngine() {
		
		return cacheManager.getEhcache(cacheName);
	}

	public String getCacheName() {
		return cacheName;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

}
