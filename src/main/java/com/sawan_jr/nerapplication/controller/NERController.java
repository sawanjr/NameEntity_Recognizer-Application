package com.sawan_jr.nerapplication.controller;

import com.sawan_jr.nerapplication.model.Type;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController // handles HTTP requests and returns JSON or XML responses.
@RequestMapping(value = "/api/v1")  //It is mapped to the endpoint /api/v1, so all its methods will be accessible under this base URL.
public class NERController {

    private final StanfordCoreNLP stanfordCoreNLP;

    public NERController(StanfordCoreNLP stanfordCoreNLP) {  //dependency injection, where Spring Framework injects the required dependencies.
        this.stanfordCoreNLP = stanfordCoreNLP;
    }

    @PostMapping("/ner") //handles HTTP POST requests to the /api/v1/ner endpoint.
    public Set<String> ner(@RequestBody final String input, @RequestParam final Type type) {
        CoreDocument coreDocument = new CoreDocument(input); // coreDocument object is created with the input text
        stanfordCoreNLP.annotate(coreDocument);  //invokes Stanford NLP's annotation pipeline to process the input text and annotate it with named entities.
        List<CoreLabel> coreLabels = coreDocument.tokens(); //The annotated tokens are retrieved from coreDocument using coreDocument.tokens().
        return new HashSet<>(collectList(coreLabels, type)); //The collectList method is called to filter and collect tokens based on the specified entity type.
        //The filtered tokens are returned as a Set<String> containing the original text of the named entities.
    }

    private List<String> collectList(List<CoreLabel> coreLabels, final Type type) {
        return coreLabels
                .stream()
                .filter(coreLabel -> type.getName().equalsIgnoreCase(coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class)))
                .map(CoreLabel::originalText)
                .collect(Collectors.toList());
    }
}
