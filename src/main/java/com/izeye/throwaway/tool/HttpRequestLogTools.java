package com.izeye.throwaway.tool;

/**
 * Tools for HTTP request logs.
 *
 * @author Johnny Lim
 */
public final class HttpRequestLogTools {

    public static void main(String[] args) {
        String requestLogLines = "GET /persons/1 HTTP/1.1\n" +
                "host: localhost:8080\n" +
                "user-agent: curl/7.64.1\n" +
                "accept: */*";

        String curl = HttpRequestLogTools.convertRequestLogToCurl(requestLogLines);
        System.out.println(curl);
    }

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
        return "curl -s -X " + method + " \"http://" + host + uri + "\" \\\n" + headerOptions + appendBody(body);
    }

    private static String appendBody(StringBuilder body) {
        return body.length() > 0 ? " \\\n --data '" + body + "'" : "";
    }

    private HttpRequestLogTools() {
    }

}
