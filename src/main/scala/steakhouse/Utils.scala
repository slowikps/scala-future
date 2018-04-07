package steakhouse

import java.util.concurrent.TimeUnit

object Utils {

  val start = System.currentTimeMillis
  def info(msg: String) = printf("%.2f: [%.20s] %s\n", (System.currentTimeMillis - start) / 1000.0, Thread.currentThread().toString, msg)

  def delay(in: String, delay: Int = 250): String = {
    info(s"about to prepare: $in")
    TimeUnit.MILLISECONDS.sleep(delay)
    info(s"ready: $in")
    in
  }
}
