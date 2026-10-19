//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    ejercicio8();
}
/*
public static void ejercicio7(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Escribe la ruta completa de una carpeta");
    String ruta=sc.nextLine();
    File carpeta=new File(ruta);
    ArrayList<File> archivos =carpeta.listFiles();
    for(int=0;i<archivos.length;i++){
        File archivo=archivos[n];
        String extension=archivo.getName().split("\.")[1];
        archivo.renameTo("archivo"+n+"."+extension);

    }
}*/
public static void ejercicio8(){
    Path pathQuijote =Path.of("resources","el_quijote.txt");
    ArrayList<String> lines=new ArrayList<String>();
    ArrayList<String> chapters=new ArrayList<String>();
    ArrayList<String> firstLines=new ArrayList<String>();
    String chapter="";
    boolean writing=false;
    try {
        lines=(ArrayList<String>)Files.readAllLines(pathQuijote);
        for(String line:lines) {
            if(line.contains("CAPÍTULO")){
                writing=true;
            }
            if(writing&&line.equals(line.toUpperCase())) {
                chapter+= line;
            }else if(writing){
                chapters.add(chapter);
                chapter="";
                writing=false;
                firstLines.add(line);
            }
        }
        for(int i=0;i<chapters.size();i++){
            IO.println(chapters.get(i));
            IO.println(firstLines.get(i));
            IO.println("\n\n\n");
        }
    }
    catch (IOException e){

    }

}
