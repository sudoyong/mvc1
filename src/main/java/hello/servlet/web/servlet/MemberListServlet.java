package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<html>");
        printWriter.write("<head>");
        printWriter.write("    <meta charset=\"UTF-8\">");
        printWriter.write("    <title>Title</title>");
        printWriter.write("</head>");
        printWriter.write("<body>");
        printWriter.write("<a href=\"/index.html\">메인</a>");
        printWriter.write("<table>");
        printWriter.write("    <thead>");
        printWriter.write("    <th>id</th>");
        printWriter.write("    <th>username</th>");
        printWriter.write("    <th>age</th>");
        printWriter.write("    </thead>");
        printWriter.write("    <tbody>");

        for (Member member : members) {
            printWriter.write("    <tr>");
            printWriter.write("        <td>" + member.getId() + "</td>");
            printWriter.write("        <td>" + member.getUsername() + "</td>");
            printWriter.write("        <td>" + member.getAge() + "</td>");
            printWriter.write("    </tr>");
        }

        printWriter.write("    </tbody>");
        printWriter.write("</table>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}
