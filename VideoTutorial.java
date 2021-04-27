public class VideoTutorial {
    public String title; 
    public String description;
    public String duration; 
    public String quality;

    public VideoTutorial(String title, String description, String duration,  String quality){
        this.title = title; 
        this.description = description; 
        this.duration = duration; 
        this.quality = quality; 
    }
    
    public String toString(){
        return "Título: " + this.title + "\nDescripción: " + this.description + "\nDuración: " + this.duration + "\nCalidad: " + this.quality;
    }

    public void pauseVideo(){
        System.out.println("Vídeo pausado");
    }

    public void resumeVideo(){
        System.out.println("Vídeo renaudado"); 
    }

    public void playVideo(){
        System.out.println("---Vídeo reproduciendo---");
        //this.toString(); 
    } 

    public void forwardVideo(){
        System.out.println("Vídeo adelantado 15 segundos"); 
    }

    public void backVideo(){
        System.out.println("Video atradado 10 segundos");
    }
}