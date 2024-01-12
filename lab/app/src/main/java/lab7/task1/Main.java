package lab7.task1;

import lab7.task1.document.text.BoldTextSegment;
import lab7.task1.document.text.ItalicTextSegment;
import lab7.task1.document.text.PlainTextSegment;
import lab7.task1.document.text.TextSegment;
import lab7.task1.document.text.UrlSegment;

import utils.TaskUnitTask;

import java.util.ArrayList;
import java.util.List;

public class Main extends TaskUnitTask {
    public static List<TextSegment> getTextSegments() {
        List<TextSegment> textSegments = new ArrayList<>();

        textSegments.add(new PlainTextSegment("Mecanismul din spatele pattern-ului "));
        textSegments.add(new ItalicTextSegment("Visitor"));
        textSegments.add(new PlainTextSegment(" poartă numele de "));
        textSegments.add(new BoldTextSegment("double-dispatch"));
        textSegments.add(new PlainTextSegment(".\n"));
        textSegments.add(new UrlSegment("http://elf.cs.pub.ro/poo/laboratoare/tutorial-doubledispatch",
                "Tutorialul de double-dispatch"));
        textSegments.add(new PlainTextSegment(" oferă mai multe detalii legate de acest mecanism.\n"));
        textSegments.add(new PlainTextSegment("Pattern-ul "));
        textSegments.add(new BoldTextSegment("Visitor"));
        textSegments.add(new PlainTextSegment(" este util când se doreşte prelucrarea unei "));
        textSegments.add(new ItalicTextSegment("structuri complexe"));
        textSegments.add(new PlainTextSegment(", ce cuprinde mai multe "));
        textSegments.add(new ItalicTextSegment("obiecte de tipuri diferite"));
        textSegments.add(new PlainTextSegment(".\n"));

        return textSegments;
    }

    @Override
    public void main() {

        List<TextSegment> textSegments = getTextSegments();

        WikiGenerator generator = new WikiGenerator(textSegments);

        System.out.println("----------------------Dokuwiki----------------------");
        System.out.println(generator.getDokuWikiDocument());
        System.out.println("---------------------MardownWiki--------------------");
        System.out.println(generator.getMarkdownDocument());
    }

    @Override
    public int getId() {
        return 1;
    }
}
