package gradebook;

public class GradeBook {

    private String courseName; // Armazena nome do curso

    // Inicializa o construtor
    // Inicializa a variável courseName com o valor fornecido quando um novo objeto GradeBook é criado.
    public GradeBook(String name) {
        courseName = name;
    }

    // Método para configurar o nome
    // Permite alterar o nome do curso depois que o objeto foi criado.
    public void setCourseName(String name) {
        courseName = name;
    }

    // Método para recuperar o nome do curso
    // Retorna o valor atual do nome do curso
    public String getCourseName() {
        return courseName;
    }

    // Exibe uma mensagem
    public void displayMessage() {
        System.out.printf("Welcome to the course: \n%s!\n", getCourseName());
    }
    public void newMessage() {
        System.out.printf("You changed the name of the course: \n%s!\n", getCourseName());
    }

}
