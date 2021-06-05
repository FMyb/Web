<template>
    <div>
        <article v-for="post in viewPosts" :key="post.id">
            <div class="title">
                <a href="#" @click.prevent="changePageToPostId(post)">{{ post.title }}</a>
            </div>
            <div class="information">By {{ post.user.login }}</div>
            <div class="body">{{ post.text }}</div>
            <div class="footer">
                <div class="left">
                    <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
                    <span class="positive-score">+173</span>
                    <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
                </div>
                <div class="right">
                    <img src="../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
                    <a href="#" @click.prevent="changePageToPostId(post)">{{ post.comments.length}}</a>
                </div>
            </div>
        </article>
    </div>
</template>

<script>
export default {
    name: "Index",
    props: ["posts", "users"],
    computed: {
        viewPosts: function () {
            return Object.values(this.posts).sort((a, b) => b.id - a.id);
        }
    },
    methods: {
        changePageToPostId: function (post) {
            this.$root.$emit("onChangePageToPost", post)
        }
    }
}
</script>

<style scoped>

</style>