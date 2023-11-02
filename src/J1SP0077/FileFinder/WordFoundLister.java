
package J1SP0077.FileFinder;

import java.io.File;


public class WordFoundLister extends FileLister{

    private String word;

    public WordFoundLister(String word, File parent) {
        super(parent);
        this.word = word;
    }
        
    @Override
    public boolean isFoundFile(File file) {
        FileFinder finder = new FileFinder(file);
        
        return finder.contain(this.word);
    }
    
}
