package MultiThreading;

/*
    程序(Program):是為完成特定任務、用某種語言編寫的一組指令的集合。即指一段靜態的代碼，靜態對象。

    進程(Process):是程序的一次執行過程，或是正在運行的一個程序。是一個動態的過程：有它自身的產生、存在和消亡的過程。 ——生命週期
        如：運行中的QQ，運行中的MP3播放器
        程序是靜態的，進程是動態的
        進程作為資源分配的單位，系統在運行時會為每個進程分配不同的內存區域

    線程(Threading):進程可進一步細化為線程，是一個程序內部的一條執行路徑。
        若一個進程同一時間並行執行多個線程，就是支持多線程的
        線程作為調度和執行的單位，每個線程擁有獨立的運行棧和程序計數器(pc)，線程切換的開銷小
        一個進程中的多個線程共享相同的內存單元/內存地址空間它們從同一堆中分配對象，可以
        訪問相同的變量和對象。這就使得線程間通信更簡便、高效。但多個線程操作共享的系統資
        源可能就會帶來安全的隱患。

    并發:一個CPU同時執行多個任務。比如:電商秒殺。


    Java的線程:一個Java應用程序java.exe，其實至少有三個線程：main()主線程，gc()垃圾回收線程，異常處理線程。當然如果發生異常，會影響主線程。

    線程的創建與啟動:
        Java語言的JVM允許程序運行多個線程，它通過java.lang.Thread類來體現。




 */

public class MultiThreadingIntro {

}
