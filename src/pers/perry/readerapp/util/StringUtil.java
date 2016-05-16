package pers.perry.readerapp.util;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

public class StringUtil {

	private static final String[] typeUri = new String[] {
			"/picturesSrc/home/", "/picturesSrc/music/", "/musicsSrc/",
			"/picturesSrc/picture/" };
	private static final String[] typeName = new String[] { "首页图片", "音乐图标",
			"音乐文件", "图片" };

	public StringUtil() {
		// TODO Auto-generated constructor stub
	}

	// 判断String为空
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	// 判断文件格式合法性,文件类型匹配性
	public static boolean isMIME(String fileName, String dir) {
		if (null == fileName || "".equals(fileName.trim())) {
			return false;
		}
		// 格式不合法
		if (!(fileName.endsWith(".mp3") || fileName.endsWith(".jpg")
				|| fileName.endsWith(".png") || fileName.endsWith(".bmp"))) {
			return false;
		}
		// .mp3文件类型不匹配(异或运算)
		if (fileName.endsWith(".mp3") ^ typeUri[2].equals(dir)) {
			return false;
		}
		// .jpg/.png/.bmp类型不匹配问题无需验证,因为都是图片
		return true;
	}

	// MD5加密算法
	public static String getMD5(byte[] source) {
		String s = null;
		// 用来将字节转换成16进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			// MD5 的计算结果是一个 128 位的长整数
			byte tmp[] = md.digest();
			// 用字节表示就是 16 个字节
			// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			char str[] = new char[16 * 2];
			// 进制需要 32 个字符
			// 表示转换结果中对应的字符位置
			int k = 0;
			// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
			for (int i = 0; i < 16; i++) {
				// 进制字符的转换
				// 取第 i 个字节
				byte byte0 = tmp[i];
				// 取字节中高 4 位的数字转换,// >>>
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 为逻辑右移，将符号位一起右移
				// 取字节中低 4 位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];

			}
			// 换后的结果转换为字符串
			s = new String(str);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static Map<String, String> loadFileName(Integer index) {
		// 查询图片,音乐的路径,在页面中以下拉列表的形式显示,用户不能随意填写
		Map<String, String> map = new HashMap<String, String>();
		// "/"是参考值,实际无用处
		map.put("/", "/");
		String dirPath = ServletActionContext.getServletContext().getRealPath(
				typeUri[index]);
		File dir = new File(dirPath);
		// 是目录,获取目录中的文件名字
		if (dir.isDirectory()) {
			String[] names = dir.list();
			for (int i = 0; i < names.length; i++) {
				map.put(typeUri[index] + names[i], typeUri[index] + names[i]);
			}
		}
		return map;
	}

	public static Map<String, String> loadTypeName() {
		Map<String, String> map = new HashMap<String, String>();
		for (int index = 0; index < typeName.length; index++) {
			map.put(typeUri[index], typeName[index]);
		}
		// map.put(typeName[index], );
		return map;
	}

	@Test
	public void ceshi() {
		String result = StringUtil.getMD5("liupengfei".getBytes());
		System.out.println(result);
	}

}
