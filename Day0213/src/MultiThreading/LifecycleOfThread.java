package MultiThreading;
/*
    Thread類中有一個State類定義了線程的幾種狀態:
        新建： 當一個Thread類或其子類的對像被聲明並創建時，新生的線程對象處於新建狀態
        就緒：處於新建狀態的線程被start()後，將進入線程隊列等待CPU時間片，此時它已具備了運行的條件，只是沒分配到CPU資源
        運行：當就緒的線程被調度並獲得CPU資源時,便進入運行狀態， run()方法定義了線程的操作和功能
        阻塞：在某種特殊情況下，被人為掛起或執行輸入輸出操作時，讓出 CPU 並臨時中止自己的執行，進入阻塞狀態
        死亡：線程完成了它的全部工作或線程被提前強制性地中止或出現異常導致結束

        圖: https://imgur.com/a/SsVrAim



 */
public class LifecycleOfThread {

}
