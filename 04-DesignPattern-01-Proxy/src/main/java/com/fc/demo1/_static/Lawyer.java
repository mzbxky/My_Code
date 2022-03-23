package com.fc.demo1._static;
//代理类
public class Lawyer implements Lawsuit{
    //包含一个真实被代理的对象
    private final Lawsuit lawsuit;

    public Lawyer(Lawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }

    @Override
    public void submit() {
        this.gatherEvidence();
        lawsuit.submit();
    }

    @Override
    public void defend() {
        lawsuit.defend();
        this.compareNotes();
    }
    //搜集证据，代理对被代理增强
    public void gatherEvidence(){
        System.out.println("搜集证据");
    }
    //交换意见
    public void compareNotes(){
        System.out.println("交换意见，如果被告不服，继续提起诉讼");
    }
//    //包含一个被代理的对象
//    private  final Lawsuit lawsuit;
//
//    public Lawyer(Lawsuit lawsuit) {
//        this.lawsuit = lawsuit;
//    }
//
//    @Override
//    public void submit() {
//        this.gatherEvidence();
//        lawsuit.submit();
//    }
//
//    @Override
//    public void defend() {
//        lawsuit.defend();
//        this.compareNotes();
//    }
//    //搜集证据，代理对被代理增强
//    public void gatherEvidence(){
//        System.out.println("搜集证据");
//    }
//    //交换意见
//    public void compareNotes(){
//        System.out.println("交换意见，如果被告不服，继续上诉");
//    }



//    // 包含一个真实被代理对象
//    private final Lawsuit lawsuit;
//
//    public Lawyer(Lawsuit lawsuit) {
//        this.lawsuit = lawsuit;
//    }
//
//    @Override
//    public void submit() {
//        this.gatherEvidence();
//        lawsuit.submit();
//    }
//
//    @Override
//    public void defend() {
//        lawsuit.defend();
//        this.compareNotes();
//    }
//    //搜集证据，代理对被代理曾强
//    public void gatherEvidence(){
//        System.out.println("搜集证据");
//    }
//    //交换意见
//    public void compareNotes(){
//        System.out.println("交换意见，如果被告不服，继续上诉");
//    }
}
