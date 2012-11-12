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

import java.util.TimerTask;

public class SampleDataTask extends TimerTask {

	@Override
	public void run() {
		
		System.out.println("Simulating a very difficult task for retrieving data...");
	}

}
