package io.collective.articles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.collective.restsupport.BasicHandler;
import org.eclipse.jetty.server.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArticlesController extends BasicHandler {
    private final ArticleDataGateway gateway;

    public ArticlesController(ObjectMapper mapper, ArticleDataGateway gateway) {
        super(mapper);
        this.gateway = gateway;
    }

    @Override
    public void handle(String target, Request request, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        get("/articles", List.of("application/json", "text/html"), request, servletResponse, () -> {

            {
                List<ArticleRecord> allRecords = gateway.findAll();
                List<ArticleInfo> allInfo = convertRecordInfo(allRecords);
                writeJsonBody(servletResponse, allInfo);
            }
        });

        get("/available", List.of("application/json"), request, servletResponse, () -> {

            {
                List<ArticleRecord> availableRecords = gateway.findAvailable();
                List<ArticleInfo> availableInfo = convertRecordInfo(availableRecords);
                writeJsonBody(servletResponse, availableInfo);
            }
        });
    }

    private List<ArticleInfo> convertRecordInfo(List<ArticleRecord> records) {
        List<ArticleInfo> info = new ArrayList<>();
        records.forEach(record -> info.add(new ArticleInfo(record.getId(), record.getTitle())));
        return info;
    }
}
