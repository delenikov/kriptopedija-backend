package com.kriptopedija.DataInit;

import com.kriptopedija.Models.*;
import com.kriptopedija.Models.DTOs.NewsDto;
import com.kriptopedija.Models.DTOs.RegisterDto;
import com.kriptopedija.Models.Enumeration.Role;
import com.kriptopedija.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final UserService userService;

    private final CourseService courseService;
    private final TestService testService;

    private final NewsService newsService;
    private final CryptoService cryptoService;

    private final QuestionService questionService;
    private final AnswerService answerService;

    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initData() {

        // Add course
        Course course1 = new Course(1L, "Introduction to Blockchain", "qOVAbKKSH10");
        Course course2 = new Course(2L, "Bitcoin", "bBC-nXj3Ng4");
        Course course3 = new Course(3L, "Cryptocurrency Full Coruse", "dgjZ2fHg4y4");
        Course course4 = new Course(4L, "What is DeFi", "17QRFlml4pA");
        Course course5 = new Course(5L, "What is Cryptography", "5jpgMXt1Z9Y");
        Course course6 = new Course(6L, "Ethereum", "04f1YsVntw8");

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
        courseService.save(course5);
        courseService.save(course6);

        // Add Users to Database
        RegisterDto admin = new RegisterDto("admin", "admin123",
                "admin123", "Admin", "Administrator", Role.ROLE_ADMIN);

        RegisterDto user = new RegisterDto("user", "user123",
                "user123", "User", "User", Role.ROLE_USER);

        userService.register(admin);
        userService.register(user);

        // Add Crypto to Database
        Crypto Bitcoin = new Crypto("Bitcoin", "BTC", "https://bitcoin.org/img/icons/opengraph.png",  25765.5, 1200000, "bitcoin.org", true, "Proof of Work");
        Crypto Ethereum = new Crypto("Ethereum", "ETC", "https://cryptologotypes.com/img/logos/ethereum/ethereum-eth-logo.png", 1835.8, 1200000, "ethereum.org", true, "Dagger Hashimoto/Ethash");
        Crypto AdaCardano = new Crypto("Ada Cardano", "ADA", "https://s2.coinmarketcap.com/static/img/coins/200x200/2010.png", 0.5, 337565071, "cardano.org/", true, "Proof of stake");
        Crypto Solana = new Crypto("Solana", "SOL", "https://upload.wikimedia.org/wikipedia/en/b/b9/Solana_logo.png", 40.5, 346972037, "solana.com", true, "Proof of stake");
        Crypto BinanceCoin = new Crypto("Binance Coin", "BNB", "https://altcoinreviews.org/wp-content/uploads/2021/11/bnbb.png", 200.5, 531212037, "binance.com", true, "Proof of stake");
        Crypto Ripple = new Crypto("Ripple", "XRP", "https://s2.coinmarketcap.com/static/img/coins/200x200/52.png", 0.37, 123972037, "ripple.com", true, "RPCA");

        cryptoService.save(Bitcoin);
        cryptoService.save(Ethereum);
        cryptoService.save(AdaCardano);
        cryptoService.save(Solana);
        cryptoService.save(BinanceCoin);
        cryptoService.save(Ripple);

        // Add News to DataBase
        NewsDto news1 = new NewsDto("Инвеститорите во УК треба да ги лимитираат чуваните коини",
                "Elementum facilisis leo vel fringilla est ullamcorper. Congue quisque egestas diam in arcu cursus euismod. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend.",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elit scelerisque mauris pellentesque pulvinar. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Pharetra et ultrices neque ornare aenean euismod elementum nisi. Odio eu feugiat pretium nibh ipsum. Ut faucibus pulvinar elementum integer enim neque volutpat. Feugiat sed lectus vestibulum mattis. Magna sit amet purus gravida quis blandit turpis cursus. Mollis nunc sed id semper risus in hendrerit gravida rutrum. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Imperdiet massa tincidunt nunc pulvinar sapien et. Sed felis eget velit aliquet sagittis id consectetur. Maecenas sed enim ut sem. Urna et pharetra pharetra massa massa ultricies mi quis. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit.");

        NewsDto news2 = new NewsDto("Нова крипто валута до крајот на Јуни",
                "Elementum facilisis leo vel fringilla est ullamcorper. Congue quisque egestas diam in arcu cursus euismod. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elit scelerisque mauris pellentesque pulvinar. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Pharetra et ultrices neque ornare aenean euismod elementum nisi. Odio eu feugiat pretium nibh ipsum. Ut faucibus pulvinar elementum integer enim neque volutpat. Feugiat sed lectus vestibulum mattis. Magna sit amet purus gravida quis blandit turpis cursus. Mollis nunc sed id semper risus in hendrerit gravida rutrum. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Imperdiet massa tincidunt nunc pulvinar sapien et. Sed felis eget velit aliquet sagittis id consectetur. Maecenas sed enim ut sem. Urna et pharetra pharetra massa massa ultricies mi quis. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit.");

        NewsDto news3 = new NewsDto("Приватна фирма одлучи да дава плати во крипто",
                "Elementum facilisis leo vel fringilla est ullamcorper. Congue quisque egestas diam in arcu cursus euismod. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elit scelerisque mauris pellentesque pulvinar. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Pharetra et ultrices neque ornare aenean euismod elementum nisi. Odio eu feugiat pretium nibh ipsum. Ut faucibus pulvinar elementum integer enim neque volutpat. Feugiat sed lectus vestibulum mattis. Magna sit amet purus gravida quis blandit turpis cursus. Mollis nunc sed id semper risus in hendrerit gravida rutrum. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Imperdiet massa tincidunt nunc pulvinar sapien et. Sed felis eget velit aliquet sagittis id consectetur. Maecenas sed enim ut sem. Urna et pharetra pharetra massa massa ultricies mi quis. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit.");

        NewsDto news4 = new NewsDto("Владата на ЈАР сака да ги забрани криптовалутите",
                "Elementum facilisis leo vel fringilla est ullamcorper. Congue quisque egestas diam in arcu cursus euismod. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elit scelerisque mauris pellentesque pulvinar. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Pharetra et ultrices neque ornare aenean euismod elementum nisi. Odio eu feugiat pretium nibh ipsum. Ut faucibus pulvinar elementum integer enim neque volutpat. Feugiat sed lectus vestibulum mattis. Magna sit amet purus gravida quis blandit turpis cursus. Mollis nunc sed id semper risus in hendrerit gravida rutrum. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Imperdiet massa tincidunt nunc pulvinar sapien et. Sed felis eget velit aliquet sagittis id consectetur. Maecenas sed enim ut sem. Urna et pharetra pharetra massa massa ultricies mi quis. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit.");

        NewsDto news5 = new NewsDto("Америка почна да користи Биткоин",
                "Elementum facilisis leo vel fringilla est ullamcorper. Congue quisque egestas diam in arcu cursus euismod. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elit scelerisque mauris pellentesque pulvinar. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Pharetra et ultrices neque ornare aenean euismod elementum nisi. Odio eu feugiat pretium nibh ipsum. Ut faucibus pulvinar elementum integer enim neque volutpat. Feugiat sed lectus vestibulum mattis. Magna sit amet purus gravida quis blandit turpis cursus. Mollis nunc sed id semper risus in hendrerit gravida rutrum. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Imperdiet massa tincidunt nunc pulvinar sapien et. Sed felis eget velit aliquet sagittis id consectetur. Maecenas sed enim ut sem. Urna et pharetra pharetra massa massa ultricies mi quis. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit.");


        newsService.save(news1);
        newsService.save(news2);
        newsService.save(news3);
        newsService.save(news4);
        newsService.save(news5);

        // Add test for course
        Test test1 = new Test("Blockchain Test");
        test1.setCourse(course1);
        Test test2 = new Test("Bitcoin Test");
        test2.setCourse(course2);
        Test test3 = new Test("Cryptocurrency Test");
        test3.setCourse(course3);
        Test test4 = new Test("DeFi Test");
        test4.setCourse(course4);
        Test test5 = new Test("Cryptography Test");
        test5.setCourse(course5);
        Test test6 = new Test("Ethereum Test");
        test6.setCourse(course6);


        // Add questions for test
        List<Question> test1questions = new ArrayList<>();
        Question q1 = new Question(1L, "Whats Bitcoin?");
        Question q2 = new Question(2L, "When arrived Bitcoin?");
        Question q3 = new Question(3L, "On which technology is Bitcoin made?");

        test1questions.add(q1);
        test1questions.add(q2);
        test1questions.add(q3);
        test1.setQuestions(test1questions);

        testService.save(test1);
       //testService.save(test2);
       //testService.save(test3);
       //testService.save(test4);
       //testService.save(test5);
       //testService.save(test6);

        q1.setTest(test1);
        questionService.save(q1);
        q2.setTest(test1);
        questionService.save(q2);
        q3.setTest(test1);
        questionService.save(q3);

        // Add answers for the question
        List<Answer> answerList1 = new ArrayList<>();
        Answer answer1 = new Answer(1L, "Crypto", true);
        answer1.setQuestion(q1);
        Answer answer2 = new Answer(2L, "Money", false);
        answer2.setQuestion(q1);
        Answer answer3 = new Answer(3L, "Program", false);
        answer3.setQuestion(q1);
        Answer answer4 = new Answer(4L, "Bank", false);
        answer4.setQuestion(q1);
        answerService.save(answer1);
        answerService.save(answer2);
        answerService.save(answer3);
        answerService.save(answer4);
        answerList1.add(answer1);
        answerList1.add(answer2);
        answerList1.add(answer3);
        answerList1.add(answer4);
        q1.setAnswers(answerList1);

        List<Answer> answerList2 = new ArrayList<>();
        Answer answer5 = new Answer(5L, "2007", false);
        answer5.setQuestion(q2);
        Answer answer6 = new Answer(6L, "2008", false);
        answer6.setQuestion(q2);
        Answer answer7 = new Answer(7L, "2009", false);
        answer7.setQuestion(q2);
        Answer answer8 = new Answer(8L, "2010", true);
        answer8.setQuestion(q2);
        answerService.save(answer5);
        answerService.save(answer6);
        answerService.save(answer7);
        answerService.save(answer8);
        answerList2.add(answer5);
        answerList2.add(answer6);
        answerList2.add(answer7);
        answerList2.add(answer8);
        q2.setAnswers(answerList2);

        List<Answer> answerList3 = new ArrayList<>();
        Answer answer9 = new Answer(9L, "Blockchain", false);
        answer9.setQuestion(q3);
        Answer answer10 = new Answer(10L, "Solana Server", true);
        answer10.setQuestion(q3);
        Answer answer11 = new Answer(11L, "Windows", false);
        answer11.setQuestion(q3);
        Answer answer12 = new Answer(12L, "Cloud", false);
        answer12.setQuestion(q3);
        answerService.save(answer9);
        answerService.save(answer10);
        answerService.save(answer11);
        answerService.save(answer12);
        answerList3.add(answer9);
        answerList3.add(answer10);
        answerList3.add(answer11);
        answerList3.add(answer12);
        q3.setAnswers(answerList3);

    }

}
