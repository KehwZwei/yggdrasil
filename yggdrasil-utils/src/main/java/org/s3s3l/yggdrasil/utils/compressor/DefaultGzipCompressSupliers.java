  
package org.s3s3l.yggdrasil.utils.compressor;

import java.util.function.Supplier;

/**
 * <p>
 * </p> 
 * ClassName:CompressSupliers <br> 
 * Date:     Apr 15, 2019 11:38:51 AM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
public class DefaultGzipCompressSupliers implements Supplier<Compressor> {

    @Override
    public Compressor get() {
        return new GzipCompressor();
    }

}
  