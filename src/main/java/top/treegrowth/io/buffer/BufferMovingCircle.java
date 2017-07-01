package top.treegrowth.io.buffer;

import java.awt.*;

/**
 * @author wusi
 * @version 2017/7/1 21:36.
 */
public class BufferMovingCircle extends NoBufferMovingCircle{

    private static final long serialVersionUID = 2368957924540877537L;
    Graphics doubleBuffer = null;					//缓冲区

    public void init() {
        super.init();
        doubleBuffer = screenImage.getGraphics();
    }

    public void paint(Graphics g) {
        doubleBuffer.setColor(Color.white);			//先在内存中画图
        doubleBuffer.fillRect(0, 0, 200, 100);
        drawCircle(doubleBuffer);

        g.drawImage(screenImage, 0, 0, this);		//将buffer一次性显示出来
    }
}
