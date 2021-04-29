public class VideoTutorial {
    public String title; 
    public String description;
    public String duration; 
    public String quality;

    //Crear vídeo
    public VideoTutorial(String title, String description, String duration,  String quality){
        this.title = title; 
        this.description = description; 
        this.duration = duration; 
        this.quality = quality; 
    }
    
    //Mostrar los valores de los atributos del video tutorial
    public String toString(){
        return "Título: " + this.title + "\nDescripción: " + this.description + "\nDuración: " + this.duration + "\nCalidad: " + this.quality;
    }

    //Pausar vídeo
    public void pauseVideo(){
        System.out.println("Vídeo pausado");
    }

    //Renaudar vídeo
    public void resumeVideo(){
        System.out.println("Vídeo renaudado"); 
    }

    //Reproducir vídeo
    public void playVideo(){
        System.out.println("---Vídeo reproduciendo---");
        //this.toString(); 
    } 

    //Adelantar vídeo
    public void forwardVideo(){
        System.out.println("Vídeo adelantado 15 segundos"); 
    }

    //Atrasar video
    public void backVideo(){
        System.out.println("Video atradado 10 segundos");
    }
}