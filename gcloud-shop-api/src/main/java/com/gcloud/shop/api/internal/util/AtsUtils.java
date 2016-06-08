package com.gcloud.shop.api.internal.util;

import com.gcloud.shop.api.ApiException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AtsUtils
 * @Package com.gcloud.shop.api.internal.util
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:41
 */
public class AtsUtils {
    private static final Set<String> CONTENT_TYPES = new HashSet();
    private static final Pattern REGEX_FILE_NAME = Pattern.compile("attachment;filename=\"([\\w\\-]+)\"");

    private AtsUtils() {
    }

    public static File ungzip(File gzip, File toDir) throws IOException {
        toDir.mkdirs();
        File out = new File(toDir, gzip.getName());
        GZIPInputStream gin = null;
        FileOutputStream fout = null;

        try {
            FileInputStream fin = new FileInputStream(gzip);
            gin = new GZIPInputStream(fin);
            fout = new FileOutputStream(out);
            copy(gin, fout);
            gin.close();
            fout.close();
        } finally {
            closeQuietly((InputStream)gin);
            closeQuietly((OutputStream)fout);
        }

        return out;
    }

    public static List<File> unzip(File zip, File toDir) throws IOException {
        ZipFile zf = null;
        ArrayList files = null;

        try {
            zf = new ZipFile(zip);
            files = new ArrayList();
            Enumeration entries = zf.entries();

            while(entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry)entries.nextElement();
                if(entry.isDirectory()) {
                    (new File(toDir, entry.getName())).mkdirs();
                } else {
                    InputStream input = null;
                    FileOutputStream output = null;

                    try {
                        File f = new File(toDir, entry.getName());
                        input = zf.getInputStream(entry);
                        output = new FileOutputStream(f);
                        copy(input, output);
                        files.add(f);
                    } finally {
                        closeQuietly((OutputStream)output);
                        closeQuietly(input);
                    }
                }
            }
        } finally {
            if(zf != null) {
                zf.close();
            }

        }

        return files;
    }

    public static File download(String url, File toDir) throws ApiException {
        toDir.mkdirs();
        HttpURLConnection conn = null;
        FileOutputStream output = null;
        File file = null;

        try {
            conn = getConnection(new URL(url));
            String e = conn.getContentType();
            String rsp;
            if(!CONTENT_TYPES.contains(e)) {
                rsp = WebUtils.getResponseAsString(conn);
                throw new ApiException(rsp);
            }

            rsp = getFileName(conn);
            file = new File(toDir, rsp);
            output = new FileOutputStream(file);
            copy(conn.getInputStream(), output);
        } catch (IOException var11) {
            throw new ApiException(var11);
        } finally {
            closeQuietly((OutputStream)output);
            if(conn != null) {
                conn.disconnect();
            }

        }

        return file;
    }

    public static File download(String url, File toDir, String fileName) throws ApiException {
        toDir.mkdirs();
        HttpURLConnection conn = null;
        FileOutputStream output = null;
        File file = null;

        try {
            conn = getConnection(new URL(url));
            String e = conn.getContentType();
            if(!CONTENT_TYPES.contains(e)) {
                String rsp = WebUtils.getResponseAsString(conn);
                throw new ApiException(rsp);
            }

            file = new File(toDir, fileName);
            output = new FileOutputStream(file);
            copy(conn.getInputStream(), output);
        } catch (IOException var12) {
            throw new ApiException(var12);
        } finally {
            closeQuietly((OutputStream)output);
            if(conn != null) {
                conn.disconnect();
            }

        }

        return file;
    }

    public static boolean checkMd5sum(File file, String checkCode) throws IOException {
        DigestInputStream dInput = null;

        try {
            FileInputStream fInput = new FileInputStream(file);
            dInput = new DigestInputStream(fInput, getMd5Instance());
            byte[] buf = new byte[8192];

            while(dInput.read(buf) > 0) {
                ;
            }

            byte[] bytes = dInput.getMessageDigest().digest();
            boolean var6 = bytes2hex(bytes).equals(checkCode);
            return var6;
        } finally {
            closeQuietly((InputStream)dInput);
        }
    }

    private static String bytes2hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(bytes[i] & 255);
            if(hex.length() == 1) {
                sb.append("0").append(hex);
            } else {
                sb.append(hex);
            }
        }

        return sb.toString();
    }

    private static MessageDigest getMd5Instance() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (Exception var1) {
            throw new RuntimeException(var1);
        }
    }

    private static String getFileName(HttpURLConnection conn) {
        String fileName = conn.getHeaderField("Content-Disposition");
        Matcher matcher = REGEX_FILE_NAME.matcher(fileName);
        return matcher.find()?matcher.group(1):null;
    }

    private static HttpURLConnection getConnection(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "application/zip;text/html");
        return conn;
    }

    private static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyStream(input, output);
        return count > 2147483647L?-1:(int)count;
    }

    private static long copyStream(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        long count = 0L;

        int n1;
        for(boolean n = false; -1 != (n1 = input.read(buffer)); count += (long)n1) {
            output.write(buffer, 0, n1);
        }

        return count;
    }

    private static void closeQuietly(OutputStream output) {
        try {
            if(output != null) {
                output.close();
            }
        } catch (IOException var2) {
            ;
        }

    }

    private static void closeQuietly(InputStream input) {
        try {
            if(input != null) {
                input.close();
            }
        } catch (IOException var2) {
            ;
        }

    }

    static {
        CONTENT_TYPES.add("application/octet-stream");
        CONTENT_TYPES.add("application/java-archive");
    }
}
