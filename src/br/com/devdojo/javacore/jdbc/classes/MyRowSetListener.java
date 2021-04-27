package br.com.devdojo.javacore.jdbc.classes;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

public class MyRowSetListener implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("Comando execute foi executado");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Quando a linha for atualizada, inserida ou deletada");
        if(event.getSource() instanceof RowSet){
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Todas as vezes que o cursor se mover");
    }
}
