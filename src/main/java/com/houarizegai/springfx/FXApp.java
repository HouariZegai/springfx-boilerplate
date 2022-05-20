package com.houarizegai.springfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class FXApp extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.setTitle("Spring FX");
        stage.show();
    }

    private Parent createContent() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/fxml/home.fxml"));
        loader.setControllerFactory(this::createControllerForType);
        return loader.load();
    }

    private Object createControllerForType(Class<?> type) {
        return this.context.getBean(type);
    }

    @Override
    public void init() {
        this.context = new SpringApplicationBuilder()
                .sources(SpringFxApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() {
        this.context.stop();
        Platform.exit();
    }
}
