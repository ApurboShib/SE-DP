public class TextFormatterStrategy
{

    public static void main(String[] args) {
        TextEditor upper = new TextEditor(new Uppercase());
        System.out.println(upper.formet("hello world!"));

        TextEditor lower = new TextEditor(new Lowercase());
        System.out.println(lower.formet("HELLO WORLD!"));
    }
}

interface TestFormetting {
    String formet (String str);
}

class Uppercase implements TestFormetting {
    public String formet(String str) {
        return "Uppercase letter is : " + str.toUpperCase();
    }
}

class Lowercase implements TestFormetting {
    public String formet (String str) {
        return "Lowercase letter is  : " + str.toLowerCase();
    }
}

class TextEditor {
    private TestFormetting formeting;
    
    public TextEditor (TestFormetting formeting) {
        this.formeting = formeting;
    }
    public String formet(String str) {
        return formeting.formet(str);
    }
}
