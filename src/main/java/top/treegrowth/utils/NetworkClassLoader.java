package top.treegrowth.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;


/**
 * Network class Loader to load Classes on different JVMs needed to provide a
 * AbstractModel Defined Functions (Filter API) on the server side w/o needing to add jar
 * on each server.
 *
 * @author wusi
 * @version 2017/2/19 10:38.
 *          from https://github.com/voldemort/voldemort
 *          src/java/voldemort/utils/NetworkClassLoader.java
 */

public class NetworkClassLoader extends ClassLoader {

    private final static Logger logger = LoggerFactory.getLogger(NetworkClassLoader.class);

    public NetworkClassLoader(ClassLoader parentClassLoader) {
        super(parentClassLoader);
    }

    public Class<?> loadClass(String className, byte[] classBuffer, int offset, int length) {
        Class<?> loadedClass = super.findLoadedClass(className);

        if (null == loadedClass) {
            return super.defineClass(className, classBuffer, offset, length);
        }

        return loadedClass;
    }

    /**
     * Utility function to convert Class --> byte[] <br>
     * call {@link ClassLoader#getResource(String)} internally to find the class
     * file and then dump the bytes[]
     *
     * @param cl The class
     * @return Byte representation of the class
     * @throws IOException
     */
    public byte[] dumpClass(Class<?> cl) throws IOException {
        // get class fileName
        // Using File.separatorChar in Windows fails. paths for
        // Class#getResource() must be forward slashes in order to work
        // correctly.
        // See:
        // https://blogs.atlassian.com/2006/12/how_to_use_file_separator_when/
        String filename = cl.getName().replace('.', '/') + ".class";
        InputStream in = null;
        logger.debug("NetworkClassloader dumpClass() :" + cl.getCanonicalName());
        try {
            in = this.getResourceAsStream(filename);
            byte[] classBytes = IOUtils.toByteArray(in);
            return classBytes;
        } finally {
            if (null != in)
                in.close();
        }
    }
}
