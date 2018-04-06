package sample;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Controller {
    public Pane pnlGame;

    public Button btnNewGame;
    public Button btnExitGame;
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public ImageView img4;
    public ImageView img5;
    public ImageView img6;
    public ImageView img7;
    public ImageView img8;
    public ImageView img9;
    public ImageView img10;
    public ImageView img11;
    public ImageView img12;
    public ImageView img13;
    public ImageView img14;
    public ImageView img15;
    public ImageView img16;
    private State state = State.NEW;
    private boolean[][] field = new boolean[4][4];

    public void img1Click(MouseEvent mouseEvent) {
        processClick(1);
    }

    public void img2Click(MouseEvent mouseEvent) {
        processClick(2);
    }

    public void img3Click(MouseEvent mouseEvent) {
        processClick(3);
    }

    public void img4Click(MouseEvent mouseEvent) {
        processClick(4);
    }

    public void img5Click(MouseEvent mouseEvent) {
        processClick(5);
    }

    public void img6Click(MouseEvent mouseEvent) {
        processClick(6);
    }

    public void img7Click(MouseEvent mouseEvent) {
        processClick(7);
    }

    public void img8Click(MouseEvent mouseEvent) {
        processClick(8);
    }

    public void img9Click(MouseEvent mouseEvent) {
        processClick(9);
    }

    public void img10Click(MouseEvent mouseEvent) {
        processClick(10);
    }

    public void img11Click(MouseEvent mouseEvent) {
        processClick(11);
    }

    public void img12Click(MouseEvent mouseEvent) {
        processClick(12);
    }

    public void img13Click(MouseEvent mouseEvent) {
        processClick(13);
    }

    public void img14Click(MouseEvent mouseEvent) {
        processClick(14);
    }

    public void img15Click(MouseEvent mouseEvent) {
        processClick(15);
    }

    public void img16Click(MouseEvent mouseEvent) {
        processClick(16);
    }

    public void processClick(int i) {
        try{
            if(state == State.PLAYING || state == State.GENERATE)
            {
                System.out.println("You cliccked on "+i);
                switch (i)
                {
                    case 1: toggle(2); toggle(5);toggle(6);break;
                    case 2: toggle(1); toggle(3);toggle(5); toggle(6);toggle(7);break;
                    case 3: toggle(2); toggle(4);toggle(6); toggle(7);toggle(8);break;
                    case 4: toggle(3); toggle(7);toggle(8);break;
                    case 5: toggle(1); toggle(2);toggle(6); toggle(9);toggle(10);break;
                    case 6: toggle(1); toggle(2);toggle(3);toggle(5);toggle(7);toggle(9);toggle(10);toggle(11);break;
                    case 7: toggle(2); toggle(3);toggle(4);toggle(6);toggle(8);toggle(10);toggle(11);toggle(12);break;
                    case 8: toggle(3); toggle(4);toggle(7);toggle(11);toggle(12);break;
                    case 9: toggle(5); toggle(6);toggle(10);toggle(13);toggle(14);break;
                    case 10: toggle(5); toggle(6);toggle(7);toggle(9);toggle(11);toggle(13);toggle(14);toggle(15);break;
                    case 11: toggle(6); toggle(7);toggle(8);toggle(10);toggle(12);toggle(14);toggle(15);toggle(16);break;
                    case 12: toggle(7); toggle(8);toggle(11);toggle(15);toggle(16);break;
                    case 13: toggle(9); toggle(10);toggle(14);break;
                    case 14: toggle(9); toggle(10);toggle(11);toggle(13);toggle(15);break;
                    case 15: toggle(10); toggle(11);toggle(12);toggle(14);toggle(16);break;
                    case 16: toggle(11); toggle(12);toggle(15);break;
                }
                if (isGameWin()) {
                    state=State.END;
                    System.out.println("You win!");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private boolean isGameWin() {
        int count = 0;
        for (int i = 0;i<4;i++)
            for (int j = 0; j<4; j++)
                if (field[i][j]==true)
                    count++;
        if (count==16 || count==0)
            return true;
        else
            return false;
    }

    public void NewGame(){
        try {
            state = State.PLAYING;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++) {
                    field[i][j]=false;
                }
            generateField();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void generateField() {
        int i;
        try {
            state = State.GENERATE;
            Random random = new Random();
            for (i = 0; i < 99; i++){
                toggle(random.nextInt(16)+1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void toggle(int i) throws Exception {
        try{
            int col = (i - 1) % 4;
            int row = (i - 1) / 4;
            field[row][col] = !field[row][col];
            Image image;
            if (field[row][col] == false) {
                image=new Image(new FileInputStream( "/D:/SOVY/GameOX/out/production/GameOX/resource/O.png"));
            }
            else{
                image=new Image(new FileInputStream( "/D:/SOVY/GameOX/out/production/GameOX/resource/X.png"));
            }
            switch (i){

                case 1: img1.setImage(image); break;
                case 2: img2.setImage(image); break;
                case 3: img3.setImage(image); break;
                case 4: img4.setImage(image); break;
                case 5: img5.setImage(image); break;
                case 6: img6.setImage(image); break;
                case 7: img7.setImage(image); break;
                case 8: img8.setImage(image); break;
                case 9: img9.setImage(image); break;
                case 10: img10.setImage(image); break;
                case 11: img11.setImage(image); break;
                case 12: img12.setImage(image); break;
                case 13: img13.setImage(image); break;
                case 14: img14.setImage(image); break;
                case 15: img15.setImage(image); break;
                case 16: img16.setImage(image); break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void ExitGame() throws IOException {
        //zatvoorit formular
        try {
            state = State.END;
            Stage stage = (Stage) btnExitGame.getScene().getWindow();
            Stage nextStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private class java {
    }
}


/*public void Game() throws IOException {

        try{
        if (game == true) {
            //start game
            boolean img = false;
            String source = new String();

            boolean arr[][] = new boolean[4][4];
            for (int i=0;i<4;i++)
                for (int j=0;j<4;j++){
                    arr[i][j] = img;
                }

            if (img == false) {
                source = "@..\\resource\\O.png";
            } else {
                source = "@..\\resource\\X.png";
            }
            String finalSource = source;
            img1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    img2.setImage(new Image(finalSource));
                    img5.setImage(new Image(finalSource));
                    img6.setImage(new Image(finalSource));
                    System.out.println("Tile pressed ");
                    event.consume();
                }
            });
            /*
            ObjectProperty<EventHandler<? super MouseEvent>> eventHandlerObjectProperty = img1.onMouseClickedProperty(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    img2.setImage(new Image(finalSource));
                    img5.setImage(new Image(finalSource));
                    img6.setImage(new Image(finalSource));
                }
                }

            for (int i=0;i<4;i++)
                for (int j=0;j<4;j++){
                if (arr[i][j] == false || arr[i][j] == true){
                        //vyskocenie okna vyhral si
                    }
                }
        }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }*/