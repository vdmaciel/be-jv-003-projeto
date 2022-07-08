package org.letscode.shoppingcart.core.persistence;

import org.letscode.shoppingcart.core.contracts.IPersistor;
import org.letscode.shoppingcart.core.data.EntityRegistry;
import org.letscode.shoppingcart.core.data.Store;
import org.letscode.shoppingcart.core.entity.Entity;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FilePersistor implements IPersistor {


    // serialização: gravando o objetos no arquivo binário "nomeArq"
    public static <T extends Store> void gravarArquivoBinario(Map<String, Store<Entity<Object>, Object>> lista, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.close();

        } catch(IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    // desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
    public static Map<String, Store<Entity<Object>, Object>> lerArquivoBinario(String nomeArq) {

        Map<String, Store<Entity<Object>, Object>> lista = new HashMap<String, Store<Entity<Object>, Object>>();
            try {
                File arq = new File(nomeArq);
                if (arq.exists()) {
                    ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                    lista = (Map<String, Store<Entity<Object>, Object>>)objInput.readObject();
                    objInput.close();
                }
            } catch(IOException erro1) {
                System.out.printf("Erro: %s", erro1.getMessage());
            } catch(ClassNotFoundException erro2) {
                System.out.printf("Erro: %s", erro2.getMessage());
            }

            return lista;
        }

    @Override
    public void persist(EntityRegistry storage) {
        this.gravarArquivoBinario(storage.getStores(), "banco_de_dados.txt");
        // TODO Auto-generated method stub
        
    }

    @Override
    public EntityRegistry retrieve() {
        // TODO Auto-generated method stub

        return new EntityRegistry(lerArquivoBinario("banco_de_dados.txt"));
    }
    
}
