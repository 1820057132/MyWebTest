package com.neusoft.servletTest.common;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import static java.awt.Font.BOLD;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * Created by xhbg on 2018/8/14.
 */
@WebServlet("/codeservlet")
public class codeServlet extends HttpServlet {

    private char[] CODES = {'2', '3', '4', '5', '6', '7', '8', '9',
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'p',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k',
            'z', 'x', 'c', 'v', 'b', 'n', 'm',
            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'P',
            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
            'Z', 'X', 'C', 'V', 'B', 'N', 'M'
    };

    private Integer HEIGHT = 20;
    private Integer WIDTH = 50;
    private Integer CODELEGTH = 4;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        Font font = new Font("Arial", BOLD, 18);
        g.setFont(font);

        Random ra = new Random();

        g.setColor(new Color(ra.nextInt(55) + 200, ra.nextInt(55) + 200, ra.nextInt(55) + 200));
        g.fillRect(0, 0, WIDTH, HEIGHT);//FILL


        g.setColor(Color.BLACK);
        g.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);


        String code = "";
        for (Integer i = 0; i < CODELEGTH; i++) {
            String str = String.valueOf(CODES[ra.nextInt(CODES.length)]);
            code += str;
            g.setColor(new Color(ra.nextInt(200), ra.nextInt(200), ra.nextInt(200)));
            g.drawString(str, 12 * i + 1, 16);


        }
        req.getSession().setAttribute("code", code);

        for (Integer i = 0; i < 4; i++) {
            g.setColor(new Color(ra.nextInt(200), ra.nextInt(200), ra.nextInt(200)));
            int x1 = ra.nextInt(WIDTH);
            int x2 = ra.nextInt(WIDTH);
            int y1 = ra.nextInt(HEIGHT);
            int y2 = ra.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
        g.dispose();
        OutputStream out = resp.getOutputStream();

        ImageIO.write(image, "JPEG", out);


    }
}
