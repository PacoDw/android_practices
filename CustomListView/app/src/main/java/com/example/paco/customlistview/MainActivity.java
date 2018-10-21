package com.example.paco.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList animals;
    private ListView animalsList;
    private TextView celda, content;

    private void rellenarArrayList() {
        animals.add(new Animal("Aguila","Ave rapaz diurna de hasta 1 m de altura, plumaje generalmente marrón oscuro, alas de gran envergadura, pico fuerte y curvado en la punta, vista muy aguda y vuelo rapidísimo." ,R.drawable.aguila));
        animals.add(new Animal("Ballena","La ballena, el mayor animal existente en la Tierra, es una especie protegida que se pesca por su grasa y sus barbas.", R.drawable.ballena));
        animals.add(new Animal("Caballo","Mamífero équido, macho, de tamaño mediano o grande, pelo corto de color generalmente uniforme y orejas cortas.", R.drawable.caballo));
        animals.add(new Animal("Camaleon","Persona que cambia de opinión, actitud o imagen con facilidad y según le conviene.", R.drawable.camaleon));
        animals.add(new Animal("Canario","Los canarios enseñan a cantar a sus polluelos; los canarios se crían por su canto y por su belleza", R.drawable.canario));
        animals.add(new Animal("Cerdo", "Mamífero paquidermo de cuerpo pesado y rechoncho, piel generalmente rosada o parda con fuertes cerdas, cabeza grande, hocico chato y casi cilíndrico, grandes orejas caídas, patas cortas.",R.drawable.cerdo));
        animals.add(new Animal("Delfin","Los delfines pueden aprender a realizar tareas complejas, comunicarse entre ellos y, mediante entrenamiento, vocalizar sonidos parecidos a palabras.", R.drawable.delfin));
        animals.add(new Animal("Gato", "Hay gatos salvajes, como el serval o el gato montés, pero la mayoría de ellos son domésticos; el gato de Angora tiene el pelo muy denso y suave.",R.drawable.gato));
        animals.add(new Animal("Iguana","Por su aspecto, las iguanas recuerdan a algunos reptiles antediluvianos.", R.drawable.iguana));
        animals.add(new Animal("Lince","Los linces marcan sus territorios con orina; los antiguos atribuían al lince una extraordinaria agudeza visual.", R.drawable.lince));
        animals.add(new Animal("Lobo", "Los lobos emiten un aullido característico; según la leyenda, Rómulo y Remo fueron amamantados por una loba.",R.drawable.lobo_9));
        animals.add(new Animal("Morena","Pez marino parecido a la anguila, de hasta 1,5 m de longitud, color marrón, cabeza alargada y puntiaguda, boca ancha muy hendida, y aletas dorsal y anal que llegan hasta la cola.", R.drawable.morena));
        animals.add(new Animal("Orca", "Mamífero marino de la familia del delfín, de unos 10 m de longitud, azul oscuro en el lomo y blanco en el vientre, con una gran aleta dorsal; es rápido y voraz.",R.drawable.orca));
        animals.add(new Animal("Perro","Perro amaestrado; los perros se cruzan para obtener distintas razas; la perra parió tres cachorritos.", R.drawable.perro));
        animals.add(new Animal("Vaca", "Mamífero rumiante bóvido, hembra, de unos 150 cm de altura y 250 cm de longitud, cuerpo muy robusto, pelo corto, cabeza gruesa provista de dos cuernos curvos y puntiagudos, hocico ancho.",R.drawable.vaca));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animals = new ArrayList<Animal>();
        rellenarArrayList();

        celda = findViewById(R.id.txtCelda);
        content = findViewById(R.id.txtContent);
        animalsList = findViewById(R.id.listView);

        animalsList.setAdapter(new AnimalsAdapter(this, animals));
        animalsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animal animal = (Animal) parent.getItemAtPosition(position);

                celda.setText("Celda: " + animal.getIdImage());

                content.setText("Content: " + animal.getDescription());
            }
        });


    }
}
