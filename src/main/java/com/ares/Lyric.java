package com.ares;

/**
 * 歌词
 * Created by ares on 2017/12/21.
 */
public class Lyric {


    /**
     * sgc : false
     * sfy : false
     * qfy : false
     * lrc : {"version":23,"lyric":"[00:00.00] 作曲 : 戚小恋\n[00:01.00] 作词 : 姚若龙\n[00:22.700]你瘦了憔悴得让我好心疼\n[00:26.700] 有时候爱情比时间还残忍\n[00:31.299] 把人变得盲目而奋不顾身\n[00:35.299] 忘了爱要两个同样用心的人\n[00:41.299] 你醉了脆弱得藏不住泪痕\n[00:46.299] 我知道绝望比冬天还寒冷\n[00:50.299] 你恨自己是个怕孤独的人\n[00:54.299] 偏偏又爱上自由自私的灵魂\n[01:02.299] 你带着它唯一写过的情书\n[01:07.299] 想证明当初爱得并不糊涂\n[01:11.299] 他曾为了你的逃离颓废痛苦\n[01:16.299] 也为了破镜重圆抱着你哭\n[01:22.899] 哦 可惜爱不是几滴眼泪几封情书 哦---\n[01:27.899] 这样的话也许有点残酷\n[01:32.899] 等待着别人给幸福的人\n[01:36.899] 往往过的都不怎么幸福\n[01:41.899] 哦 可惜爱不是忍着眼泪留着情书 哦---\n[01:46.899] 伤口清醒要比昏迷痛楚\n[01:51.899] 禁闭着双眼又拖着错误\n[01:55.899] 真爱来临时你要怎么留得住\n[02:19.900] 你醉了脆弱得藏不住泪痕\n[02:24.600] 我知道绝望比冬天还寒冷\n[02:27.600] 你恨自己是个怕孤独的人\n[02:32.600] 偏偏又爱上自由自私的灵魂\n[02:40.600] 你带着它唯一写过的情书\n[02:44.600] 想证明当初爱得并不糊涂\n[02:49.600] 他曾为了你的逃离颓废痛苦\n[02:54.600] 也为了破镜重圆抱着你哭\n[03:01.800] 哦 可惜爱不是几滴眼泪几封情书 哦---\n[03:06.800] 这样的话也许有点残酷\n[03:11.800] 等待着别人给幸福的人\n[03:15.800] 往往过的都不怎么幸福\n[03:19.800] 哦 可惜爱不是忍着眼泪留着情书 哦---\n[03:25.800] 伤口清醒要比昏迷痛楚\n[03:30.800] 禁闭着双眼又拖着错误\n[03:33.800] 真爱来临时你要怎么留得住\n"}
     * code : 200
     */

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LrcBean lrc;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LrcBean getLrc() {
        return lrc;
    }

    public void setLrc(LrcBean lrc) {
        this.lrc = lrc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LrcBean {
        /**
         * version : 23
         * lyric : [00:00.00] 作曲 : 戚小恋
         [00:01.00] 作词 : 姚若龙
         [00:22.700]你瘦了憔悴得让我好心疼
         [00:26.700] 有时候爱情比时间还残忍
         [00:31.299] 把人变得盲目而奋不顾身
         [00:35.299] 忘了爱要两个同样用心的人
         [00:41.299] 你醉了脆弱得藏不住泪痕
         [00:46.299] 我知道绝望比冬天还寒冷
         [00:50.299] 你恨自己是个怕孤独的人
         [00:54.299] 偏偏又爱上自由自私的灵魂
         [01:02.299] 你带着它唯一写过的情书
         [01:07.299] 想证明当初爱得并不糊涂
         [01:11.299] 他曾为了你的逃离颓废痛苦
         [01:16.299] 也为了破镜重圆抱着你哭
         [01:22.899] 哦 可惜爱不是几滴眼泪几封情书 哦---
         [01:27.899] 这样的话也许有点残酷
         [01:32.899] 等待着别人给幸福的人
         [01:36.899] 往往过的都不怎么幸福
         [01:41.899] 哦 可惜爱不是忍着眼泪留着情书 哦---
         [01:46.899] 伤口清醒要比昏迷痛楚
         [01:51.899] 禁闭着双眼又拖着错误
         [01:55.899] 真爱来临时你要怎么留得住
         [02:19.900] 你醉了脆弱得藏不住泪痕
         [02:24.600] 我知道绝望比冬天还寒冷
         [02:27.600] 你恨自己是个怕孤独的人
         [02:32.600] 偏偏又爱上自由自私的灵魂
         [02:40.600] 你带着它唯一写过的情书
         [02:44.600] 想证明当初爱得并不糊涂
         [02:49.600] 他曾为了你的逃离颓废痛苦
         [02:54.600] 也为了破镜重圆抱着你哭
         [03:01.800] 哦 可惜爱不是几滴眼泪几封情书 哦---
         [03:06.800] 这样的话也许有点残酷
         [03:11.800] 等待着别人给幸福的人
         [03:15.800] 往往过的都不怎么幸福
         [03:19.800] 哦 可惜爱不是忍着眼泪留着情书 哦---
         [03:25.800] 伤口清醒要比昏迷痛楚
         [03:30.800] 禁闭着双眼又拖着错误
         [03:33.800] 真爱来临时你要怎么留得住

         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }
}
