package proyectofinal;

import java.util.ArrayList;

/**
 * Repositorio de las 200 palabras del juego, distribuidas en 5 categorias.
 * Cada palabra incluye su categoria y una pista descriptiva.
 * Las palabras se cargan al instanciar la clase mediante metodos privados por categoria.
 *
 * @author Amanda Carolina Chindoy Muchavisoy
 */
public class BancoPalabras {

    private ArrayList<Palabra> palabras;

    public BancoPalabras() {
        palabras = new ArrayList<>();
        cargarAnimales();
        cargarPaises();
        cargarDeportes();
        cargarComidas();
        cargarObjetos();
    }

    private void cargarAnimales() {
        palabras.add(new Palabra("HIPOPOTAMO",  Categorias.ANIMALES, "Especie invasora en los ecosistemas de Colombia"));
        palabras.add(new Palabra("DELFIN",      Categorias.ANIMALES, "Mamifero marino conocido por su inteligencia"));
        palabras.add(new Palabra("JAGUAR",      Categorias.ANIMALES, "Felino mas grande de America"));
        palabras.add(new Palabra("CONDOR",      Categorias.ANIMALES, "Ave simbolo de los Andes"));
        palabras.add(new Palabra("MARIPOSA",    Categorias.ANIMALES, "Insecto de alas coloridas que surge de una crisalida"));
        palabras.add(new Palabra("TORTUGA",     Categorias.ANIMALES, "Reptil de larga vida y caparazon duro"));
        palabras.add(new Palabra("ELEFANTE",    Categorias.ANIMALES, "Animal terrestre mas grande del mundo"));
        palabras.add(new Palabra("PINGUINO",    Categorias.ANIMALES, "Ave que no puede volar y vive en el sur"));
        palabras.add(new Palabra("CAMELLO",     Categorias.ANIMALES, "Animal del desierto con joroba"));
        palabras.add(new Palabra("COCODRILO",   Categorias.ANIMALES, "Reptil acuatico de grandes mandibulas"));
        palabras.add(new Palabra("GORILA",      Categorias.ANIMALES, "El primate mas grande del mundo"));
        palabras.add(new Palabra("TIBURON",     Categorias.ANIMALES, "El predador marino mas temido"));
        palabras.add(new Palabra("CABALLO",     Categorias.ANIMALES, "Animal domestico usado para montar y trabajar"));
        palabras.add(new Palabra("LORO",        Categorias.ANIMALES, "Ave que puede imitar el habla humana"));
        palabras.add(new Palabra("IGUANA",      Categorias.ANIMALES, "Reptil tipico de America tropical"));
        palabras.add(new Palabra("CANGURO",     Categorias.ANIMALES, "Animal australiano con bolsa marsupial"));
        palabras.add(new Palabra("PULPO",       Categorias.ANIMALES, "Molusco marino con ocho tentaculos"));
        palabras.add(new Palabra("AGUILA",      Categorias.ANIMALES, "Ave rapaz de gran vision y vuelo alto"));
        palabras.add(new Palabra("BALLENA",     Categorias.ANIMALES, "El animal mas grande del planeta"));
        palabras.add(new Palabra("GUEPARDO",    Categorias.ANIMALES, "El animal terrestre mas rapido del mundo"));
        palabras.add(new Palabra("RINOCERONTE", Categorias.ANIMALES, "Mamifero con cuerno en la nariz"));
        palabras.add(new Palabra("FLAMINGO",    Categorias.ANIMALES, "Ave rosada de patas y cuello largos"));
        palabras.add(new Palabra("PIRANA",      Categorias.ANIMALES, "Pez carnivoro del rio Amazonas"));
        palabras.add(new Palabra("NUTRIA",      Categorias.ANIMALES, "Mamifero semi-acuatico muy jugueton"));
        palabras.add(new Palabra("PANTERA",     Categorias.ANIMALES, "Felino negro de la selva tropical"));
        palabras.add(new Palabra("BUITRE",      Categorias.ANIMALES, "Ave carronera de gran envergadura"));
        palabras.add(new Palabra("MURCIELAGO",  Categorias.ANIMALES, "Unico mamifero capaz de volar"));
        palabras.add(new Palabra("ESCORPION",   Categorias.ANIMALES, "Aracnido con veneno en la cola"));
        palabras.add(new Palabra("SALAMANDRA",  Categorias.ANIMALES, "Anfibio de colores brillantes advertencia"));
        palabras.add(new Palabra("ALCE",        Categorias.ANIMALES, "Ciervo gigante de los bosques del norte"));
        palabras.add(new Palabra("MAPACHE",     Categorias.ANIMALES, "Animal nocturno con mascara negra natural"));
        palabras.add(new Palabra("HORMIGA",     Categorias.ANIMALES, "Insecto social que vive en colonias"));
        palabras.add(new Palabra("LEON",        Categorias.ANIMALES, "El rey de la sabana africana"));
        palabras.add(new Palabra("ZORRO",       Categorias.ANIMALES, "Animal astuto del bosque con cola peluda"));
        palabras.add(new Palabra("SERPIENTE",   Categorias.ANIMALES, "Reptil sin patas que se arrastra"));
        palabras.add(new Palabra("AVESTRUZ",    Categorias.ANIMALES, "Ave terrestre mas grande, no puede volar"));
        palabras.add(new Palabra("HIENA",       Categorias.ANIMALES, "Carnivoro africano conocido por su risa"));
        palabras.add(new Palabra("KOALA",       Categorias.ANIMALES, "Marsupial australiano que come eucalipto"));
        palabras.add(new Palabra("CASTOR",      Categorias.ANIMALES, "Roedor que construye represas en rios"));
        palabras.add(new Palabra("LEOPARDO",    Categorias.ANIMALES, "Felino de manchas negras escalador"));
    }

    private void cargarPaises() {
        palabras.add(new Palabra("FRANCIA",     Categorias.PAISES, "Lugar de origen de Napoleon Bonaparte"));
        palabras.add(new Palabra("BRASIL",      Categorias.PAISES, "El pais mas grande de America del Sur"));
        palabras.add(new Palabra("JAPON",       Categorias.PAISES, "Pais insular conocido por su tecnologia"));
        palabras.add(new Palabra("EGIPTO",      Categorias.PAISES, "Pais famoso por sus piramides y el Nilo"));
        palabras.add(new Palabra("MEXICO",      Categorias.PAISES, "Pais de los mariachis y el tequila"));
        palabras.add(new Palabra("AUSTRALIA",   Categorias.PAISES, "El pais que es tambien un continente"));
        palabras.add(new Palabra("RUSIA",       Categorias.PAISES, "El pais mas extenso del mundo"));
        palabras.add(new Palabra("CHINA",       Categorias.PAISES, "El pais mas poblado del mundo"));
        palabras.add(new Palabra("INDIA",       Categorias.PAISES, "Hogar del Taj Mahal y el rio Ganges"));
        palabras.add(new Palabra("CANADA",      Categorias.PAISES, "El segundo pais mas grande del mundo"));
        palabras.add(new Palabra("ARGENTINA",   Categorias.PAISES, "Pais del tango y cuna de Messi"));
        palabras.add(new Palabra("ALEMANIA",    Categorias.PAISES, "Pais conocido por sus cervezas y automoviles"));
        palabras.add(new Palabra("ITALIA",      Categorias.PAISES, "Pais con forma de bota en el mapa"));
        palabras.add(new Palabra("COLOMBIA",    Categorias.PAISES, "El unico pais con costas en dos oceanos"));
        palabras.add(new Palabra("PERU",        Categorias.PAISES, "Pais del Machu Picchu y los Incas"));
        palabras.add(new Palabra("CHILE",       Categorias.PAISES, "El pais mas largo y angosto del mundo"));
        palabras.add(new Palabra("VENEZUELA",   Categorias.PAISES, "Pais con las cataratas mas altas del mundo"));
        palabras.add(new Palabra("PORTUGAL",    Categorias.PAISES, "Pais conquistador de grandes exploraciones maritimas"));
        palabras.add(new Palabra("GRECIA",      Categorias.PAISES, "Cuna de la democracia y los Juegos Olimpicos"));
        palabras.add(new Palabra("TURQUIA",     Categorias.PAISES, "Pais ubicado entre Europa y Asia"));
        palabras.add(new Palabra("MARRUECOS",   Categorias.PAISES, "Pais del norte de Africa"));
        palabras.add(new Palabra("NIGERIA",     Categorias.PAISES, "El pais mas poblado de Africa"));
        palabras.add(new Palabra("KENYA",       Categorias.PAISES, "Pais africano famoso por su safari"));
        palabras.add(new Palabra("SUECIA",      Categorias.PAISES, "Pais escandinavo creador de IKEA"));
        palabras.add(new Palabra("NORUEGA",     Categorias.PAISES, "Pais de los fiordos y la aurora boreal"));
        palabras.add(new Palabra("HOLANDA",     Categorias.PAISES, "Pais de los tulipanes y los molinos de viento"));
        palabras.add(new Palabra("BELGICA",     Categorias.PAISES, "Cuna del chocolate y las cervezas artesanales"));
        palabras.add(new Palabra("SUIZA",       Categorias.PAISES, "Pais neutral famoso por relojes y montanas"));
        palabras.add(new Palabra("CUBA",        Categorias.PAISES, "Isla caribena conocida por sus puros y musica"));
        palabras.add(new Palabra("JAMAICA",     Categorias.PAISES, "Pais natal del reggae y Usain Bolt"));
        palabras.add(new Palabra("FILIPINAS",   Categorias.PAISES, "Archipielago asiatico de mas de 7000 islas"));
        palabras.add(new Palabra("TAILANDIA",   Categorias.PAISES, "Pais del templo de Buda Esmeralda"));
        palabras.add(new Palabra("VIETNAM",     Categorias.PAISES, "Pais asiatico famoso por su sopa pho"));
        palabras.add(new Palabra("IRAN",        Categorias.PAISES, "Antiguo imperio persa en Oriente Medio"));
        palabras.add(new Palabra("ISRAEL",      Categorias.PAISES, "Tierra santa de tres religiones"));
        palabras.add(new Palabra("ESPANA",      Categorias.PAISES, "Pais del flamenco y la paella"));
        palabras.add(new Palabra("POLONIA",     Categorias.PAISES, "Pais europeo de gran historia medieval"));
        palabras.add(new Palabra("HAITI",       Categorias.PAISES, "Primera republica negra de la historia"));
        palabras.add(new Palabra("URUGUAY",     Categorias.PAISES, "El pais mas pequeno de America del Sur"));
        palabras.add(new Palabra("ECUADOR",     Categorias.PAISES, "Pais por donde cruza la linea del Ecuador"));
    }

    private void cargarDeportes() {
        palabras.add(new Palabra("NATACION",      Categorias.DEPORTES, "Deporte acuatico de velocidad en piscina"));
        palabras.add(new Palabra("ATLETISMO",     Categorias.DEPORTES, "El deporte mas antiguo de los Juegos Olimpicos"));
        palabras.add(new Palabra("TENIS",         Categorias.DEPORTES, "Deporte con raqueta y pelota amarilla"));
        palabras.add(new Palabra("BOXEO",         Categorias.DEPORTES, "Arte marcial con guantes de proteccion"));
        palabras.add(new Palabra("CICLISMO",      Categorias.DEPORTES, "Deporte de velocidad sobre dos ruedas"));
        palabras.add(new Palabra("VOLEIBOL",      Categorias.DEPORTES, "Deporte de red jugado en playa o cancha"));
        palabras.add(new Palabra("BALONCESTO",    Categorias.DEPORTES, "Deporte de la canasta inventado en 1891"));
        palabras.add(new Palabra("BEISBOL",       Categorias.DEPORTES, "Deporte nacional de Cuba y Venezuela"));
        palabras.add(new Palabra("RUGBY",         Categorias.DEPORTES, "Deporte de contacto con balon ovalado"));
        palabras.add(new Palabra("GOLF",          Categorias.DEPORTES, "Deporte de palos y hoyos en hierba"));
        palabras.add(new Palabra("ESGRIMA",       Categorias.DEPORTES, "Deporte de combate con espadas"));
        palabras.add(new Palabra("GIMNASIA",      Categorias.DEPORTES, "Deporte de acrobacias y flexibilidad"));
        palabras.add(new Palabra("JUDO",          Categorias.DEPORTES, "Arte marcial japonesa de lanzamientos"));
        palabras.add(new Palabra("KARATE",        Categorias.DEPORTES, "Arte marcial de golpes con manos y pies"));
        palabras.add(new Palabra("TAEKWONDO",     Categorias.DEPORTES, "Arte marcial coreana famosa por sus patadas"));
        palabras.add(new Palabra("POLO",          Categorias.DEPORTES, "Deporte ecuestre jugado con mazos"));
        palabras.add(new Palabra("SURF",          Categorias.DEPORTES, "Deporte de olas sobre una tabla"));
        palabras.add(new Palabra("ESQUI",         Categorias.DEPORTES, "Deporte de nieve sobre tablas largas"));
        palabras.add(new Palabra("PATINAJE",      Categorias.DEPORTES, "Deporte sobre hielo o ruedas"));
        palabras.add(new Palabra("HANDBALL",      Categorias.DEPORTES, "Deporte de lanzamiento con la mano a porteria"));
        palabras.add(new Palabra("FUTBOL",        Categorias.DEPORTES, "El deporte mas popular del mundo"));
        palabras.add(new Palabra("MARATON",       Categorias.DEPORTES, "Carrera de 42 kilometros de distancia"));
        palabras.add(new Palabra("WATERPOLO",     Categorias.DEPORTES, "Futbol jugado dentro de la piscina"));
        palabras.add(new Palabra("BADMINTON",     Categorias.DEPORTES, "Deporte con volante y raqueta"));
        palabras.add(new Palabra("SQUASH",        Categorias.DEPORTES, "Raqueta y pelota en cancha cerrada"));
        palabras.add(new Palabra("CURLING",       Categorias.DEPORTES, "Deporte olimpico sobre hielo con piedras"));
        palabras.add(new Palabra("ESCALADA",      Categorias.DEPORTES, "Deporte de ascenso en paredes rocosas"));
        palabras.add(new Palabra("CANOA",         Categorias.DEPORTES, "Deporte de remo en embarcacion pequena"));
        palabras.add(new Palabra("DECATLON",      Categorias.DEPORTES, "Competencia de diez disciplinas atleticas"));
        palabras.add(new Palabra("TRIATLÓN",      Categorias.DEPORTES, "Combina natacion ciclismo y carrera a pie"));
        palabras.add(new Palabra("HALTEROFILIA",  Categorias.DEPORTES, "Deporte de levantamiento de pesas"));
        palabras.add(new Palabra("PENTATLÓN",     Categorias.DEPORTES, "Competencia olimpica de cinco disciplinas"));
        palabras.add(new Palabra("CLAVADOS",      Categorias.DEPORTES, "Saltos acrobaticos desde trampolines"));
        palabras.add(new Palabra("LUCHA",         Categorias.DEPORTES, "Deporte de combate cuerpo a cuerpo"));
        palabras.add(new Palabra("REMO",          Categorias.DEPORTES, "Deporte de botes en agua con remos"));
        palabras.add(new Palabra("TIRO",          Categorias.DEPORTES, "Deporte de precision con armas de fuego"));
        palabras.add(new Palabra("ESLALON",       Categorias.DEPORTES, "Carrera con puertas de slalom en pista nevada"));
        palabras.add(new Palabra("PELOTA",        Categorias.DEPORTES, "Deporte tradicional vasco en frontones"));
        palabras.add(new Palabra("ARCHERIA",      Categorias.DEPORTES, "Deporte de precision con arco y flechas"));
        palabras.add(new Palabra("FISICOCULTURISMO", Categorias.DEPORTES, "Deporte de desarrollo muscular extremo"));
    }

    private void cargarComidas() {
        palabras.add(new Palabra("PIZZA",         Categorias.COMIDAS, "Comida italiana popular en todo el mundo"));
        palabras.add(new Palabra("SUSHI",         Categorias.COMIDAS, "Plato japones de arroz y pescado crudo"));
        palabras.add(new Palabra("TACOS",         Categorias.COMIDAS, "Comida tipica mexicana en tortilla de maiz"));
        palabras.add(new Palabra("HAMBURGUESA",   Categorias.COMIDAS, "Sandwich americano con carne molida"));
        palabras.add(new Palabra("PAELLA",        Categorias.COMIDAS, "Arroz tipico de Espana con mariscos"));
        palabras.add(new Palabra("CEVICHE",       Categorias.COMIDAS, "Plato tipico de Peru con limon y mariscos"));
        palabras.add(new Palabra("AREPAS",        Categorias.COMIDAS, "Pan de maiz tipico de Colombia y Venezuela"));
        palabras.add(new Palabra("EMPANADA",      Categorias.COMIDAS, "Masa rellena tipica de Latinoamerica"));
        palabras.add(new Palabra("TAMALES",       Categorias.COMIDAS, "Masa de maiz envuelta en hoja de platano"));
        palabras.add(new Palabra("SANCOCHO",      Categorias.COMIDAS, "Sopa tipica colombiana con tuberculos y carne"));
        palabras.add(new Palabra("AGUACATE",      Categorias.COMIDAS, "Fruta verde usada en guacamole"));
        palabras.add(new Palabra("CHOCOLATE",     Categorias.COMIDAS, "Dulce hecho del cacao originario de Mexico"));
        palabras.add(new Palabra("HELADO",        Categorias.COMIDAS, "Postre frio de leche y azucar"));
        palabras.add(new Palabra("GALLETA",       Categorias.COMIDAS, "Bizcocho pequeno y crujiente"));
        palabras.add(new Palabra("FRIJOLES",      Categorias.COMIDAS, "Legumbre tipica de la cocina latinoamericana"));
        palabras.add(new Palabra("PLATANO",       Categorias.COMIDAS, "Fruta tropical muy popular en Colombia"));
        palabras.add(new Palabra("SALMON",        Categorias.COMIDAS, "Pescado rosado rico en omega-3"));
        palabras.add(new Palabra("QUESO",         Categorias.COMIDAS, "Derivado lacteo de miles de variedades"));
        palabras.add(new Palabra("YOGURT",        Categorias.COMIDAS, "Leche fermentada cremosa y nutritiva"));
        palabras.add(new Palabra("MANGO",         Categorias.COMIDAS, "Fruta tropical amarilla muy dulce"));
        palabras.add(new Palabra("PASTA",         Categorias.COMIDAS, "Masa de trigo de origen italiano"));
        palabras.add(new Palabra("LASANA",        Categorias.COMIDAS, "Pasta en capas con queso y salsa"));
        palabras.add(new Palabra("RISOTTO",       Categorias.COMIDAS, "Arroz cremoso italiano con queso parmesano"));
        palabras.add(new Palabra("CREPE",         Categorias.COMIDAS, "Tortilla francesa muy delgada y suave"));
        palabras.add(new Palabra("CROISSANT",     Categorias.COMIDAS, "Pan frances en forma de media luna"));
        palabras.add(new Palabra("WAFFLES",       Categorias.COMIDAS, "Pan de molde con cuadros tipico del desayuno"));
        palabras.add(new Palabra("BROWNIE",       Categorias.COMIDAS, "Pastel de chocolate denso y suave"));
        palabras.add(new Palabra("TIRAMISU",      Categorias.COMIDAS, "Postre italiano de cafe y queso mascarpone"));
        palabras.add(new Palabra("RAMEN",         Categorias.COMIDAS, "Sopa japonesa con fideos y caldo"));
        palabras.add(new Palabra("BURRITO",       Categorias.COMIDAS, "Tortilla mexicana enrollada con relleno"));
        palabras.add(new Palabra("FONDUE",        Categorias.COMIDAS, "Queso suizo derretido para dipear pan"));
        palabras.add(new Palabra("TEMPURA",       Categorias.COMIDAS, "Fritura japonesa de mariscos y vegetales"));
        palabras.add(new Palabra("GUACAMOLE",     Categorias.COMIDAS, "Salsa mexicana a base de aguacate"));
        palabras.add(new Palabra("HUMMUS",        Categorias.COMIDAS, "Pasta de garbanzos del Medio Oriente"));
        palabras.add(new Palabra("GAZPACHO",      Categorias.COMIDAS, "Sopa fria espanola de tomate"));
        palabras.add(new Palabra("CROQUETAS",     Categorias.COMIDAS, "Bolitas fritas de bechamel rellenas"));
        palabras.add(new Palabra("CHURROS",       Categorias.COMIDAS, "Masa frita espanola con azucar y canela"));
        palabras.add(new Palabra("ENCHILADAS",    Categorias.COMIDAS, "Tortillas mexicanas baneadas en salsa de chile"));
        palabras.add(new Palabra("CARPACCIO",     Categorias.COMIDAS, "Carne o pescado crudo cortado muy fino"));
        palabras.add(new Palabra("SOUVLAKI",      Categorias.COMIDAS, "Brocheta de carne tipica de Grecia"));
    }

    private void cargarObjetos() {
        palabras.add(new Palabra("COMPUTADORA",     Categorias.OBJETOS, "Maquina electronica de procesamiento de datos"));
        palabras.add(new Palabra("TELESCOPIO",      Categorias.OBJETOS, "Instrumento optico para observar el espacio"));
        palabras.add(new Palabra("MICROSCOPIO",     Categorias.OBJETOS, "Instrumento para ver objetos muy pequenos"));
        palabras.add(new Palabra("CALCULADORA",     Categorias.OBJETOS, "Maquina para operaciones matematicas"));
        palabras.add(new Palabra("LAMPARA",         Categorias.OBJETOS, "Dispositivo para iluminar espacios"));
        palabras.add(new Palabra("CAMARA",          Categorias.OBJETOS, "Dispositivo para capturar imagenes y videos"));
        palabras.add(new Palabra("GUITARRA",        Categorias.OBJETOS, "Instrumento musical de seis cuerdas"));
        palabras.add(new Palabra("PIANO",           Categorias.OBJETOS, "Instrumento musical de teclas y cuerdas"));
        palabras.add(new Palabra("VIOLIN",          Categorias.OBJETOS, "Instrumento de cuerdas que se toca con arco"));
        palabras.add(new Palabra("TROMPETA",        Categorias.OBJETOS, "Instrumento de viento de metal brillante"));
        palabras.add(new Palabra("SOMBRERO",        Categorias.OBJETOS, "Prenda para cubrir y proteger la cabeza"));
        palabras.add(new Palabra("PARAGUAS",        Categorias.OBJETOS, "Accesorio para protegerse de la lluvia"));
        palabras.add(new Palabra("MOCHILA",         Categorias.OBJETOS, "Bolso que se lleva en la espalda"));
        palabras.add(new Palabra("MALETA",          Categorias.OBJETOS, "Equipaje de ruedas para viajes"));
        palabras.add(new Palabra("BICICLETA",       Categorias.OBJETOS, "Vehiculo de dos ruedas sin motor"));
        palabras.add(new Palabra("AVION",           Categorias.OBJETOS, "Vehiculo de transporte aereo con alas"));
        palabras.add(new Palabra("SUBMARINO",       Categorias.OBJETOS, "Vehiculo que navega bajo el agua"));
        palabras.add(new Palabra("MARTILLO",        Categorias.OBJETOS, "Herramienta para clavar clavos"));
        palabras.add(new Palabra("DESTORNILLADOR",  Categorias.OBJETOS, "Herramienta para ajustar tornillos"));
        palabras.add(new Palabra("TIJERAS",         Categorias.OBJETOS, "Herramienta de corte con dos hojas"));
        palabras.add(new Palabra("NEVERA",          Categorias.OBJETOS, "Electrodomestico para conservar alimentos frios"));
        palabras.add(new Palabra("MICROONDAS",      Categorias.OBJETOS, "Electrodomestico para calentar comida rapidamente"));
        palabras.add(new Palabra("LAVADORA",        Categorias.OBJETOS, "Electrodomestico para lavar ropa"));
        palabras.add(new Palabra("TELEVISOR",       Categorias.OBJETOS, "Pantalla para ver programas y peliculas"));
        palabras.add(new Palabra("AURICULARES",     Categorias.OBJETOS, "Dispositivo para escuchar audio de forma privada"));
        palabras.add(new Palabra("IMPRESORA",       Categorias.OBJETOS, "Maquina para imprimir documentos en papel"));
        palabras.add(new Palabra("ESCRITORIO",      Categorias.OBJETOS, "Mueble de trabajo con superficie plana"));
        palabras.add(new Palabra("DISKMAN",         Categorias.OBJETOS, "Reproductor de CD portatil popular en los 2000"));
        palabras.add(new Palabra("LINTERNA",        Categorias.OBJETOS, "Fuente de luz portatil de mano"));
        palabras.add(new Palabra("BRUJULA",         Categorias.OBJETOS, "Instrumento de navegacion que senala el norte"));
        palabras.add(new Palabra("TERMOMETRO",      Categorias.OBJETOS, "Instrumento para medir la temperatura"));
        palabras.add(new Palabra("BAROSCOPO",       Categorias.OBJETOS, "Instrumento que mide la presion atmosferica"));
        palabras.add(new Palabra("CRONOMETRO",      Categorias.OBJETOS, "Reloj de alta precision para medir tiempos"));
        palabras.add(new Palabra("CALEIDOSCOPIO",   Categorias.OBJETOS, "Tubo optico con figuras geometricas coloridas"));
        palabras.add(new Palabra("PERISCOPO",       Categorias.OBJETOS, "Instrumento optico para ver sobre obstaculos"));
        palabras.add(new Palabra("ALTAVOZ",         Categorias.OBJETOS, "Dispositivo que convierte senales en sonido"));
        palabras.add(new Palabra("PROYECTOR",       Categorias.OBJETOS, "Aparato que proyecta imagenes en una pantalla"));
        palabras.add(new Palabra("TECLADO",         Categorias.OBJETOS, "Periferico de entrada de texto para computadora"));
        palabras.add(new Palabra("ESCANER",         Categorias.OBJETOS, "Dispositivo que digitaliza documentos fisicos"));
        palabras.add(new Palabra("DRON",            Categorias.OBJETOS, "Vehiculo aereo no tripulado controlado remotamente"));
    }

    /**
     * Retorna la lista completa de las 200 palabras del banco.
     *
     * @return lista con todas las palabras de todas las categorias
     */
    public ArrayList<Palabra> getPalabras() {
        return palabras;
    }

    /**
     * Filtra y retorna solo las palabras de una categoria especifica.
     *
     * @param categoria la categoria por la cual filtrar
     * @return lista de palabras que pertenecen a la categoria indicada
     */
    public ArrayList<Palabra> getPalabrasPorCategoria(Categorias categoria) {
        ArrayList<Palabra> filtradas = new ArrayList<>();
        for (Palabra p : palabras) {
            if (p.getCategoria() == categoria) filtradas.add(p);
        }
        return filtradas;
    }

    /**
     * Retorna el numero total de palabras en el banco.
     *
     * @return cantidad total de palabras (200)
     */
    public int getTotalPalabras() {
        return palabras.size();
    }
}
