package solution;

import jigsaw.Jigsaw;
import jigsaw.JigsawNode;

import java.io.IOException;
import java.util.*;


/**
 * 在此类中填充算法，完成重拼图游戏（N-数码问题）
 */
public class Solution extends Jigsaw {

    /**
     * 拼图构造函数
     */
    public Solution() {
    }

    /**
     * 拼图构造函数
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
        super(bNode, eNode);
    }

    //我自行实现的一个方法，用于找到邻接节点
    private Vector<JigsawNode> findAdjNodes(JigsawNode jNode) {
        Vector<JigsawNode> AdjNodes = new Vector<>();
        JigsawNode tempJNode;
        for(int i=0; i<4; i++){ //上下左右四个方向
            tempJNode = new JigsawNode(jNode);
            //能走，并且未访问，且不在待处理队列中
            if(tempJNode.move(i) && !this.visitedList.contains(tempJNode) && !this.exploreList.contains(tempJNode))
                AdjNodes.addElement(tempJNode);
        }
        return AdjNodes;
    }


    /**
     *（实验一）广度优先搜索算法，求指定3*3拼图（8-数码问题）的最优解
     * 填充此函数，可在Solution类中添加其他函数，属性
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     * @return 搜索成功时为true,失败为false
     */
    public boolean BFSearch(JigsawNode bNode, JigsawNode eNode) throws IOException {
        beginJNode = bNode;
        endJNode = eNode;   //设置起始点，调用方法将结果输出到文件中
        Vector<JigsawNode> adjNode = new Vector<JigsawNode>();    //邻接节点

        this.exploreList = new ArrayDeque<>();
        this.visitedList = new HashSet<>(1000);

        exploreList.add(bNode);
        int maxNum = 30000;  //设置查找上限为30000次迭代
        int iterNum = 0;
        String path;

        while (!exploreList.isEmpty() && iterNum <= maxNum){    //BFS
            this.currentJNode = exploreList.poll();

            if (currentJNode.equals(eNode)){    //若是找到了结束状态，直接返回并输出结果
                getPath();
                path = getSolutionPath();
                System.out.println(path);
                printResult(null);
                return true;
            }

            iterNum++;
            searchedNodesNum++;
//            System.out.println("Searching.....Number of iterations:" + iterNum + "   Current state:" + this.currentJNode.toString());
            visitedList.add(currentJNode);
            adjNode = findAdjNodes(currentJNode);   //找到邻接的节点

            while (!adjNode.isEmpty()){     //将邻接节点加入adjNode中
                exploreList.add(adjNode.firstElement());
                adjNode.removeElementAt(0);
            }
        }
        printResult(null);  //没有找到就输出Not Completed
        return false;
    }


    /**
     *（Demo+实验二）计算并修改状态节点jNode的代价估计值:f(n)
     * 如 f(n) = s(n). s(n)代表后续节点不正确的数码个数
     * 此函数会改变该节点的estimatedValue属性值
     * 修改此函数，可在Solution类中添加其他函数，属性
     * @param jNode - 要计算代价估计值的节点
     */
    public void estimateValue(JigsawNode jNode) {
        int dimension = JigsawNode.getDimension();
        int f1 = 0; //后续节点不正确的数码个数
        int f2 = 0; //所有放错位的数码个数
        int f3 = 0; //曼哈顿距离
        int f4 = 0; //欧氏距离
        int iterNum = dimension * dimension;
        for(int index = 1; index < iterNum; index++){
            if (jNode.getNodesState()[index]+1 != jNode.getNodesState()[index+1]){
                f1++;
            }
            if (jNode.getNodesState()[index] != index && jNode.getNodesState()[0] != index) {
                f2++;
                //该数码应该在的位置
                int x1 = (index-1) / dimension;
                int y1 = (index-1) % dimension;
                //该数码现在在的位置
                int x2 = (jNode.getNodesState()[index]-1) / dimension;
                int y2 = (jNode.getNodesState()[index]-1) % dimension;
                //计算距离
                f3 += Math.abs(x1-x2) + Math.abs(y1-y2);
                f4 += Math.sqrt(Math.abs(x1-x2)) + Math.sqrt(Math.abs(y1-y2));
            }
        }
        jNode.setEstimatedValue(2*f1 + 3*f2 + 7*f3 + 1*f4);    //设置估值，此处的常数为超参数，这里是实验出来的比较好的结果
    }
}
