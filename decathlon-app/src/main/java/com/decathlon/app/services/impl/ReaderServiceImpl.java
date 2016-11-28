package com.decathlon.app.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.decathlon.app.domain.PartyDTO;
import com.decathlon.app.domain.PartyNameDTO;
import com.decathlon.app.domain.ScoresDTO;
import com.decathlon.app.services.ReaderService;
import com.decathlon.app.utils.ConverterUtils;
import com.google.common.collect.Lists;

/**
 * Implementation for {@link ReaderService}.
 *
 * @author redaz
 */
public class ReaderServiceImpl implements ReaderService {

    private static final Logger LOG = LoggerFactory.getLogger(ReaderServiceImpl.class);

    /**
     * Indicates default path to the files directory.
     * <p>
     * <b>Note:</b> this attribute is set by spring beans.
     */
    private String path;
    /**
     * Indicates file, which should be read.
     */
    private File file;

    /**
     * {@inheritDoc}
     */
    public List<PartyDTO> readLocalFile(String fileName) throws FileNotFoundException {
        LOG.trace(MessageFormat.format("[readFile] file name: {0}", fileName));
        String absolutePath = constructAbsolutePath(fileName);

        if (!isFileExist(absolutePath)) {
            throw new FileNotFoundException(MessageFormat.format("File or directory not found: {0}", absolutePath));
        }

        return readFile();
    }

    /**
     * {@inheritDoc}
     */
    public List<PartyDTO> readExternalFile(String absolutePath) throws FileNotFoundException {
        LOG.trace(MessageFormat.format("[readExternalFile] absolute path: {0}", absolutePath));

        if (!isFileExist(absolutePath)) {
            throw new FileNotFoundException(MessageFormat.format("File or directory not found: {0}", absolutePath));
        }

        return readFile();
    }

    /**
     * Constructs absolute path to the file. Includes file name as well.
     * @param fileName file name, for which absolute path is being constructed
     * @return absolute path
     */
    protected String constructAbsolutePath(String fileName) {
        Assert.notNull(fileName, "Parameter 'fileName' cannot be null");
        Assert.notNull(getPath(), "Parameter 'path' cannot be null");
        LOG.trace(MessageFormat.format("[constructAbsolutePath] path {0}, file name {1}", getPath(), fileName));

        return getPath().concat("/").concat(fileName);
    }

    /**
     * Reads file and constructs list of {@link PartyDTO}.
     *
     * @return list of party dtos
     */
    protected List<PartyDTO> readFile() {
        LOG.trace("[readFile] file reading started");
        List<PartyDTO> parties = Lists.newArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(getFile()));
            String line;
            while (StringUtils.isNotEmpty((line = br.readLine()))) {
                String[] elements = line.split(";");
                PartyNameDTO partyName = new PartyNameDTO(elements[0]);
                ScoresDTO scores = new ScoresDTO(ConverterUtils.convertToDouble(elements[1]),
                        ConverterUtils.convertToDouble(elements[2]), ConverterUtils.convertToDouble(elements[3]),
                        ConverterUtils.convertToDouble(elements[4]), ConverterUtils.convertToDouble(elements[5]),
                        ConverterUtils.convertToDouble(elements[6]), ConverterUtils.convertToDouble(elements[7]),
                        ConverterUtils.convertToDouble(elements[8]), ConverterUtils.convertToDouble(elements[9]),
                        elements[10].trim());
                parties.add(new PartyDTO(partyName, scores));
            }
            br.close();
            LOG.trace("[readFile] file reading ended");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return parties;
    }

    /**
     * Checks if file by given absolute path exists.
     * @param absolutePath path to the file, including file name
     * @return {@code TRUE} if file exists, {@code FALSE} otherwise
     */
    protected boolean isFileExist(String absolutePath) {
        Assert.notNull(absolutePath, "Parameter 'absolutePath' cannot be null");

        if (new File(absolutePath).exists()) {
            LOG.debug(MessageFormat.format("[isFileExist] file {0} exists", absolutePath));
            setFile(new File(absolutePath));
            return true;
        }

        LOG.debug(MessageFormat.format("[isFileExist] file {0} does not exist", absolutePath));
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public String readUserInput() {
        LOG.warn("\n \n ------------------------- \n >> Enter file with path: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
