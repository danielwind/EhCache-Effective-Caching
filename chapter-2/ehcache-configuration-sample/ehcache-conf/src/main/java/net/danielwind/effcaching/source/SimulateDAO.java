package net.danielwind.effcaching.source;

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

import java.util.Timer;

public final class SimulateDAO {
	
	//number of seconds to simulate delay
	private static final int delayInSeconds = 10;
	
	private static Timer timer;
	
	/**
	 * Method to simulate a high load query for sample data.
	 * This method invokes a 10 seconds timer that simulates
	 * a very long running query... 
	 * @return String[] representing a set of 3 strings
	 */
	public static String[] getSampleData(){
		
		timer = new Timer();
		timer.schedule(new SampleDataTask(), delayInSeconds*1000);
		
		String[] dataSample = new String[]{"somedata1", "somedata2", "somedata3"};
		
		return dataSample;
	}

}
