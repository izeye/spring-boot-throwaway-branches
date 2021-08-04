package com.izeye.throwaway.util;

/**
 * Utilities for HTTP request logs.
 *
 * @author Johnny Lim
 */
public final class HttpRequestLogUtils {

    public static String convertRequestLogToCurl(String requestLogLines) {
        String[] lines = requestLogLines.split("\n");
        String[] firstLine = lines[0].split(" ");
        String method = firstLine[0];
        String uri = firstLine[1];
        String host = null;
        StringBuilder headerOptions = new StringBuilder();
        StringBuilder body = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            if (!line.isEmpty()) {
                String[] pair = line.split(": ");
                if (pair[0].equals("host")) {
                    host = pair[1];
                }

                if (headerOptions.length() > 0) {
                    headerOptions.append(" \\\n");
                }

                headerOptions.append("  -H \"" + line + "\"");
            }
            else {
                for (int j = i + 1; j < lines.length; j++) {
                    if (body.length() > 0) {
                        body.append("\n");
                    }
                    body.append(lines[j]);
                }
                break;
            }
        }
        return "curl -s -X " + method + " \"http://" + host + uri + "\" \\\n" + headerOptions + " \\\n --data '" + body + "'";
    }

    private HttpRequestLogUtils() {
    }

}
