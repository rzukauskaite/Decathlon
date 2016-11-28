package com.decathlon.app.services;

import java.io.FileNotFoundException;
import java.util.List;

import com.decathlon.app.domain.PartyDTO;

/**
 * Service to read files.
 *
 * @author redaz
 */
public interface ReaderService {
    /**
     * Reads local file.
     * <p>
     * <b>Note:</b> local means, that file is located under this project
     * resources directory and user provides only file name.
     *
     * @param fileName file name, which should be read
     * @return list of competition parties
     */
    public List<PartyDTO> readLocalFile(String fileName) throws FileNotFoundException;

    /**
     * Reads external file.
     * <p>
     * <b>Note:</b> external means, that file is located somewhere and user
     * provides full path to the file and file name.
     *
     * @param absolutePath absolute path to the file, which should be read
     * @return list of competition parties
     */
    public List<PartyDTO> readExternalFile(String absolutePath) throws FileNotFoundException;
    /**
     * Requires user input, i.e.: file name and path.
     *
     * @return user entered value
     */
    public String readUserInput();
}
