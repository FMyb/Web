<template>
    <div>
        <article v-if="post">
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
                    <a href="#" @click.prevent="changePageToPostId(post)">{{ post.comments.length }}</a>
                </div>
            </div>
            <form class="writeComment" @submit.prevent="onWriteComment">
                <label for="text">Write Comment:</label> <br>
                <textarea id="text" name="text" style="resize: none" maxlength="255" v-model="text" rows="6" cols="45"></textarea>
                <div class="error">{{ error }}</div>
                <div class="button-field">
                    <input type="submit" value="Write">
                </div>
            </form>
            <div class="comment" v-for="comment in post.comments" :key="comment.id">
                <span class="author">{{ comment.user.login }}: </span>
                <span class="text">{{ comment.text }}</span>
            </div>
        </article>
        <span v-if="!post">No such post</span>
    </div>
</template>

<script>
export default {
    name: "Post",
    props: {
        post: {
            type: Object
        }
    },
    data: function () {
        return {
            text: "",
            error: ""
        }
    },
    methods: {
        changePageToPostId: function (post) {
            this.$root.$emit("onChangePageToPost", post)
        },
        onWriteComment: function () {
            this.error = "";
            this.$root.$emit("onWriteComment", this.text, this.post);
            this.$root.$emit("onChangePageToPost", this.post);
        }
    },
    beforeMount() {
        this.$root.$on("onWriteCommentValidationError", error => this.error = error);
        this.$root.$on("onAddCommentSuccess", () => this.text = "")
    }
}
</script>

<style scoped>
.error {
    color: var(--error-color);
    font-size: 0.75rem;
}
.comment {
    margin-top: 0.5rem
}

.comment .author {
    color: darkgrey
}
</style>