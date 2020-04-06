package com.soft1851.spring.jdbc.pic;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author zhao
 * @className pictureImpl
 * @Description TODO
 * @Date 2020/4/6
 * @Version 1.0
 **/
public class PictureImpl implements Picture {

    @Override
    public void watermark() {
        ImgUtil.pressText(
                FileUtil.file("d:/图片/love.jpg"),
                FileUtil.file("d:/图片/love_result.jpg"),
                "my love zxl", Color.WHITE,
                new Font("黑体", Font.BOLD, 100),
                0,
                0,
                0.8f
        );
    }

    @Override
    public void cut() throws IOException {
        // 旋转180度
        BufferedImage image = (BufferedImage) ImgUtil.rotate(ImageIO.read(FileUtil.file("d:/图片/love_result.jpg")), 180);
        ImgUtil.write(image, FileUtil.file("d:/图片/love_result1.jpg"));

    }
}
