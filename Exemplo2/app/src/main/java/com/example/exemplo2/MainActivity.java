package com.example.exemplo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inserir(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.email);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if(n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.",Toast.LENGTH_LONG).show();
            }
            else {
                bdw.execSQL("INSERT INTO contatos (nome,celular,email) "
                        + "  values ('" + n + "','" + c + "','" + e + "')");
                Toast.makeText(getApplicationContext(),
                        "Inserido com sucesso.",Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. Nome duplicado?\n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }

    public void listar(View v){
        HelperDB ch1 = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdr1 = null;
        String str= "\nContatos cadastrados\n\n";
        try {
            Context ctx = this;  // ou: Context ctx = v.getContext(); dentro de onClick
            ch1 = new HelperDB(ctx);
            bdr1 = ch1.getReadableDatabase();
            Cursor cursor = bdr1.query("contatos", null, null, null, null, null, null);
            // ou Cursor cursor = bdr.rawQuery("select * from contatos", null);
            while (cursor.moveToNext()) {
                String nom = cursor.getString(0); //campo nome (coluna 0)
                String cel = cursor.getString(1); //celular
                String em = cursor.getString(2); //email
                str += nom + ", "  + cel + ", "  + em + "\n\n";
            }
            ((TextView)findViewById(R.id.lista)).setText(str);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD.\n", Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdr1!=null) bdr1.close();
            if(ch1!=null) ch1.close();
        }
    }


    public void deletar(View v){
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            String n = nome.getText().toString();
            if(n.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, digite o nome.",Toast.LENGTH_LONG).show();
            }
            else {
                long id = bdw.delete("contatos", "nome ='"  + n + "'", null);
                if(id == 0) {
                    Toast.makeText(getApplicationContext(), "\nNão foi possível eliminar. \nVerifique o código.\n",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Deletado com sucesso.",Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                    Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdw!=null) bdw.close();
            if(ch!=null) ch.close();
        }
    }

    public void alterar(View v) {
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText celular = (EditText) findViewById(R.id.cel);
        EditText email = (EditText) findViewById(R.id.email);
        String n = nome.getText().toString();
        String c = celular.getText().toString();
        String e = email.getText().toString();
        try {
            n = nome.getText().toString();
            if(n == null) throw new Exception("erro");
        } catch (Exception erro) {
            Toast.makeText(getApplicationContext(), "\nNão foi possível alterar. \nVerifique o código.\n",
                    Toast.LENGTH_LONG).show();
        }
        ContentValues valores = new ContentValues();
        valores.put("nome", n);
        valores.put("celular", c); // Assuming "celular" is a column name in your database.
        valores.put("email", e);

        HelperDB helper = null;
        SQLiteDatabase bdw = null;
        try {
            helper = new HelperDB(getApplicationContext());
            bdw = helper.getWritableDatabase();
            long id = bdw.update("contatos", valores, "nome ='"  + n + "'", null);
            if (id == 0) {
                Toast.makeText(getApplicationContext(), "\nNão foi possível alterar!",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "\nHabitação alterada com sucesso.",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD!",
                    Toast.LENGTH_LONG).show();
        } finally {
            if (bdw != null) bdw.close();
            if (helper != null) helper.close();
        }
    }

}
