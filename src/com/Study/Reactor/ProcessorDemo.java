package com.Study.Reactor;

/**
 * 应该进行避免使用 Processor，它们较难正确使用，主要用于一些特殊场景下。
 * 如果你觉得 Processor 适合你的使用场景，请首先看一下是否尝试过以下两种替代方式：
 * 1. 是否有一个或多个操作符的组合能够满足需求？（见 我需要哪个操作符？）
 * 2. "generator" 操作符是否能解决问题？（通常这些操作符 可以用来桥接非响应式的 API，它们提供了一个“sink”，在生成数据流序列方面， 概念上类似于 Processor）
 */
public class ProcessorDemo {

}
