package com.hanu.webapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.hanu.webapp.modules.students.StudentServlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Launcher class
 */
public final class App implements Runnable {
    // constants
    private static final int DEFAULT_PORT = 8080;
    private static final String DEFAULT_HOSTNAME = "localhost";
    private static final String DEFAULT_APP_BASE = ".";
    private static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private static final String CONTEXT_PATH = "";
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private App() {
    }

    @Override
    public void run() {
        Tomcat instance = new Tomcat();
        instance.setHostname(DEFAULT_HOSTNAME);
        instance.setPort(DEFAULT_PORT);
        instance.getConnector();
        instance.getHost().setAppBase(DEFAULT_APP_BASE);
        Context context = instance.addContext(CONTEXT_PATH, TMP_DIR);
        String servletName = StudentServlet.class.getName();
        instance.addServlet(CONTEXT_PATH, servletName, new StudentServlet());
        context.addServletMappingDecoded("/students/*", servletName);
        try {
            instance.start();
        } catch (LifecycleException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Run the application.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws IOException {
        App app = new App();
        FrontendAppLauncher.launch();
        app.run();
    }

    static class FrontendAppLauncher {
        public static void launch() throws IOException {
            Process process = Runtime.getRuntime().exec(new String[]{ "bash", "-c", "nodemon " + new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/node" });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);

        }
    }
}
