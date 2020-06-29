package com.kodakestan.kodak.models.mapper;

import com.kodakestan.kodak.models.dto.ImageDto;
import com.kodakestan.kodak.models.dto.output.ImageOutputDto;
import com.kodakestan.kodak.models.entities.Image;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class ImageMapper {
    private static String imgMan = null;
    private static String imgWMan = null;

    @Inject
    private GridFS gridFS;

    public Image fileToImage(MultipartFile file) throws IOException {
        Image img = new Image();
        GridFSInputFile gridFSFile = gridFS.createFile(file.getInputStream());
        gridFSFile.setFilename((int) (Math.random() * 100000) + file.getName());
        gridFSFile.setContentType("");
        gridFSFile.save();
        img.setId((ObjectId) gridFSFile.getId());
        return img;
    }

    public Image fileToImage(ImageDto dto) throws IOException {
        if (dto.getFile() == null)
            return null;
        Image img = new Image();
        GridFSInputFile gridFSFile = gridFS.createFile(dto.getFile().getInputStream());
        gridFSFile.setFilename((int) (Math.random() * 100000) + dto.getFile().getName());
        gridFSFile.setContentType("");
        gridFSFile.save();
        img.setId((ObjectId) gridFSFile.getId());
        return img;
    }

    public List<Image> multiPartListToImage(List<MultipartFile> files) throws IOException {
        List<Image> list = new ArrayList<>();
        for (MultipartFile file : files) {
            Image img = fileToImage(file);
            list.add(img);
        }
        return list;
    }

    public List<Image> fileToImage(List<ImageDto> dtos) throws IOException {
        List<Image> list = new ArrayList<>();
        for (ImageDto dto : dtos) {
            if (dto.getFile() == null) {
                continue;
            }
            MultipartFile file = dto.getFile();
            Image img = fileToImage(file);
            list.add(img);
        }
        return list;
    }

    public ImageOutputDto imageToDto(ObjectId imageId) throws IOException {
        ImageOutputDto dto = new ImageOutputDto();

        GridFSDBFile gridFSDBFile = gridFS.find(imageId);
        byte[] bytes = IOUtils.toByteArray(gridFSDBFile.getInputStream());
        String str = Base64.getEncoder().encodeToString(bytes);

        dto.setImageStr(str);
        return dto;
    }

    public ImageOutputDto imageToImageDto(Image img) throws IOException {
        if (img == null)
            return null;
        GridFSDBFile gridFSDBFile = gridFS.find(img.getId());
        byte[] bytes = IOUtils.toByteArray(gridFSDBFile.getInputStream());
        String str = Base64.getEncoder().encodeToString(bytes);
        return new ImageOutputDto(str);
    }

    public static String getImgMan() throws IOException {
        if (imgMan != null)
            return imgMan;
        byte[] fileContent;
        fileContent = FileUtils.readFileToByteArray(new File("avatar.png"));
        imgMan = Base64.getEncoder().encodeToString(fileContent);
        return imgMan;
    }

    public static String getImgWMan() throws IOException {
        if (imgWMan != null)
            return imgWMan;
        byte[] fileContent;
        fileContent = FileUtils.readFileToByteArray(new File("avatar.png"));
        imgWMan = Base64.getEncoder().encodeToString(fileContent);
        return imgWMan;
    }
}
