package net.danielwind.effcaching.source;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

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

public class Application {
	
    public static void main(String[] args){
    	
    	if(args.length > 0) {
    		
    		int counter = 0;
    		
    		if(args[0].equals("true")){
    			 
    			//create cache manager and create cache by invoking the cache name defined in ehcache.xml 
    			CacheManager cacheManager = CacheManager.create(Application.class.getResource("/resources/ehcache.xml"));
    			Cache cache = cacheManager.getCache("datacache");
    			
    			/*******************************************************
    			 * Uncomment the below code if you want to use
    			 * CacheConfiguration Class instead of defining
    			 * ehcache.xml (showing some properties only for brevity)
    			 * 
    			 * 
    			 * CacheConfiguration config = new CacheConfiguration("datacache", 1000);
    			 * config.setMaxEntriesLocalHeap(1000);
    			 * config.setEternal(true);
    			 * config.setOverflowToDisk(false);
    			 * config.setTimeToIdleSeconds(120);
    			 * config.setTimeToLiveSeconds(120);
    			 *
    			 * Cache cache = new Cache(config);
    			 ********************************************************/
    	
    			
    			//start loop for comparing activity
    			while(counter < 5){
    				
    				long start = System.currentTimeMillis();
    				
    				System.out.println("-----------------------");
    				System.out.println("Retrieving sample data:");
    				
    				Element e = cache.get("sampleData");
    				String[] sampleDataValue = null;
    				
    				/***
    				 * We first consult our cache instance if it contains the
    				 * object with "sampleData" key. If it does, then we retrieve
    				 * it from memory cache directly. If not, then we need to query
    				 * the DAO (which is set to simulate a load of 10 seconds).
    				 * 
    				 * An important note here is that in this case, the long query will
    				 * only be executed once, because it will retrieve it from the DAO 
    				 * and then store it in cache for future access. However, depending 
    				 * on the expiry rate you configure in ehcache.xml, further access to
    				 * it will result in a new query issued to the DAO. In this case, the
    				 * string[] object will be stored again in memory and the process will
    				 * start again. 
    				 ***/
    				if(e != null) {
    					
    					sampleDataValue = (String[]) e.getValue();
    					
    				} else {
    					
    					sampleDataValue = SimulateDAO.getSampleData();
    					cache.put(new Element("sampleData", sampleDataValue));
    				}
    				
    				counter++;
    				long end = System.currentTimeMillis();
    				
    				System.out.println("Total Time Elapsed: " + (end - start)/1000);
    			}
    			
    			
    		} else if(args[0].equals("false")){
    			
    			while(counter < 5){
    				
    				long start = System.currentTimeMillis();
    				
    				System.out.println("-----------------------");
    				System.out.println("Retrieving sample data:");
    				
    				SimulateDAO.getSampleData();
    				
    				counter++;
    				long end = System.currentTimeMillis();
    				
    				System.out.println("Total Time Elapsed: " + (end - start)/1000);
    			}
    			
    		} else {
    			System.out.println("System expects arguments: true | false");
        		System.exit(0);	
    		}
    		
    	} else {
    		System.out.println("Please provide arguments: true | false");
    		System.exit(0);
    	}
    }
}
