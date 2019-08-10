package cn.layanan.exception.core.config;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;


/**
 * body读取过滤器（解决body流只可以读取一次的问题）
 *
 * @Author: lay
 * @Date: Created in 10:25 2019/8/9
 * @Modified By:IntelliJ IDEA
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;


    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.body = StreamUtils.copyToByteArray(request.getInputStream());
    }

    public byte[] getBody() {
        return body;
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new BodyReaderServletInputStream(bais);
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    private class BodyReaderServletInputStream extends ServletInputStream {
        private ByteArrayInputStream bais;

        public BodyReaderServletInputStream(ByteArrayInputStream bais) {
            this.bais = bais;
        }


        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }

        @Override
        public int read() throws IOException {
            return bais.read();
        }
    }


    public static class RequestReadUtils {

        private static final int BUFFER_SIZE = 1024 * 8;

        public static String read(HttpServletRequest request) throws IOException {
            BufferedReader bufferedReader = request.getReader();
            StringWriter writer = new StringWriter();
            write(bufferedReader,writer);
            return writer.getBuffer().toString();
        }

        public static long write(Reader reader,Writer writer) throws IOException {
            return write(reader, writer, BUFFER_SIZE);
        }

        public static long write(Reader reader, Writer writer, int bufferSize) throws IOException
        {
            int read;
            long total = 0;
            char[] buf = new char[bufferSize];
            while( ( read = reader.read(buf) ) != -1 ) {
                writer.write(buf, 0, read);
                total += read;
            }
            return total;
        }
    }

}
