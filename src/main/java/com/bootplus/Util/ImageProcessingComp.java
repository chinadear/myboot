package com.bootplus.Util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.sun.image.codec.jpeg.*;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
/**
 * 图片压缩处理类
 * @author ll
 * 2015-08-26
 */
public class ImageProcessingComp {
	//输入的图片资源
	private BufferedImage img;
	//输出的路径
	private String destFileName;
	//图片的宽
	private int width;
	//图片的高
	private int height;
	/**
	 * 构造函数
	 * @param fileName
	 * @param destFileName
	 * @throws IOException
	 */
	public ImageProcessingComp(String fileName,String destFileName) throws IOException {
		File file = new File(fileName);// 读入文件
		img = ImageIO.read(file);      // 构造Image对象
		width = img.getWidth(null);    // 得到源图宽
		height = img.getHeight(null);  // 得到源图长
		this.destFileName=destFileName;
	}
	/**
	 * 百分比缩放压缩
	 * @param percent 范围0-100
	 * @throws IOException
	 */
	public void compressByPercent(String percent) throws IOException {
		double p=Double.valueOf(percent);
		p=p/100;
		width=(int)(width*p);
		height=(int)(height*p);
		compress(width,height);
	}
	/**
	 * 以宽度为基准，等比例放缩图片
	 * @param w int 新宽度
	 */
	public void compressByWidth(int w) throws IOException {
		int h=(int)(height*w/width);
		compress(w,h);
	}
	/**
	 * 以高度为基准，等比例缩放图片
	 * @param h int 新高度
	 */
	public void compressByHeight(int h) throws IOException {
		int w=(int)(width*h/height);
		compress(w,h);
	}
	/**
	 * 强制压缩/放大图片到固定的大小
	 * @param w int 新宽度
	 * @param h int 新高度
	 */
	private void compress(int w, int h) throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB ); 
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		File destFile = new File(destFileName);
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		out.close();
	}
	/**
	 * 根据画质进行压缩
	 * @param p 范围0-1
	 * @return
	 * @throws Exception 
	 */
	public void compressByQality(String p){
        FileOutputStream out = null;
        ImageWriter imgWrier;
        ImageWriteParam imgWriteParams;
        // 指定写图片的方式为 jpg
        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
        imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
        // 这里指定压缩的程度，参数qality是取值0~1范围内，
        imgWriteParams.setCompressionQuality(Float.valueOf(p));
        imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
        ColorModel colorModel = ColorModel.getRGBdefault();
        // 指定压缩时使用的色彩模式
        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel
                .createCompatibleSampleModel(16, 16)));
        try
        {
            out = new FileOutputStream(destFileName);
            imgWrier.reset();
            // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
            imgWrier.setOutput(ImageIO.createImageOutputStream(out));
            // 调用write方法，就可以向输入流写图片
            imgWrier.write(null, new IIOImage(img, null, null), imgWriteParams);
            out.flush();
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
