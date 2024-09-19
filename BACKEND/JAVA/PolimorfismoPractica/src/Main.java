public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.setNombre("Fido");//cargo datos a los atributos
        animal.setPeso(10.5);
        animal.hacerRuido();



        Perro perro = new Perro();
        perro.setNombre("Max");//nombre y peso comparten con animal
        perro.setPeso(15.0);
        perro.hacerRuido();
        perro.buscarHueso();

        Gato gato = new Gato();
        gato.setNombre("Miau");
        gato.setPeso(4.2);
        gato.hacerRuido();
        gato.jugarConLaser();
    }
}