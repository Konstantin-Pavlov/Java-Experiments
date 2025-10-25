package org.example.arxiv;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article {
    UUID id;
    String url;
    String pdfUrl;
    String title;
    String description;
    String category;
    String subcategory;
    String section;
    List<String> authors;
    String sourceName;
    Status status;
    LocalDateTime date;
}
